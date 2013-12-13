/*
 * Copyright 2005-2013 The Kuali Foundation
 * 
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/ecl1.php
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.kra.protocol.actions.genericactions;

import java.sql.Timestamp;
import org.kuali.kra.common.notification.service.KcNotificationService;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.printing.PrintingException;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.kra.protocol.ProtocolVersionService;
import org.kuali.kra.protocol.actions.ProtocolActionBase;
import org.kuali.kra.protocol.actions.assignagenda.ProtocolAssignToAgendaService;
import org.kuali.kra.protocol.actions.correspondence.ProtocolActionCorrespondenceGenerationService;
import org.kuali.kra.protocol.actions.correspondence.ProtocolActionsCorrespondenceBase;
import org.kuali.kra.protocol.actions.submit.ProtocolActionService;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewService;
import org.kuali.rice.kew.actiontaken.ActionTakenValue;
import org.kuali.rice.kew.api.WorkflowDocument;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.DocumentService;

/**
 * This class handles the generic actions that can be made to a protocol.  A generic action contain a comment, action date, and a 
 * state change.
 */
public abstract class ProtocolGenericActionServiceImplBase implements ProtocolGenericActionService {
    
    private static final String PROTOCOL_SUBMISSION = "protocolSubmission";
    private ProtocolActionService protocolActionService;
    private DocumentService documentService;
      
    private ProtocolActionCorrespondenceGenerationService protocolActionCorrespondenceGenerationService;
    
    
    private ProtocolOnlineReviewService protocolOnlineReviewService;
    private ProtocolVersionService protocolVersionService;
    private ProtocolAssignToAgendaService protocolAssignToAgendaService;
    private BusinessObjectService businessObjectService;
    private KcNotificationService kcNotificationService;    
    
    /**
     * Performs the generic action, which includes a state change, action date, and a comment, that's it!
     * @param protocol
     * @param actionBean
     * @param protocolActionType
     * @param newProtocolStatus
     * @throws Exception
     */
    protected void performGenericAction(ProtocolBase protocol, ProtocolGenericActionBean actionBean, String protocolActionType, String newProtocolStatus) throws Exception {
        
        ProtocolActionBase protocolAction = createProtocolActionAndAttach(protocol, actionBean, protocolActionType);
        
        protocolActionService.updateProtocolStatus(protocolAction, protocol);
        protocol.setProtocolStatusCode(newProtocolStatus);
        protocol.refreshReferenceObject("protocolStatus");
        documentService.saveDocument(protocol.getProtocolDocument());
                 
        createCorrespondenceAndAttach(protocol, protocolActionType);
    }

    protected ProtocolActionBase createProtocolActionAndAttach(ProtocolBase protocol, ProtocolGenericActionBean actionBean, String protocolActionType) {
        protocol.refreshReferenceObject("protocolSubmission");
        ProtocolActionBase protocolAction = getNewProtocolActionInstanceHook(protocol, null, protocolActionType);
        protocolAction.setComments(actionBean.getComments());
        protocolAction.setActionDate(new Timestamp(actionBean.getActionDate().getTime()));
        protocol.getProtocolActions().add(protocolAction);
        
        return protocolAction;
    }
    
    protected abstract ProtocolActionBase getNewProtocolActionInstanceHook(ProtocolBase protocol, ProtocolSubmissionBase submission, String protocolActionType);
    
    protected abstract ProtocolActionsCorrespondenceBase getNewProtocolActionsCorrespondenceHook(String protocolActionType);

    protected void createCorrespondenceAndAttach(ProtocolBase protocol, String protocolActionType) throws PrintingException {
        ProtocolActionsCorrespondenceBase correspondence = getNewProtocolActionsCorrespondenceHook(protocolActionType);
        correspondence.setPrintableBusinessObject(protocol);
        correspondence.setProtocol(protocol);
        protocolActionCorrespondenceGenerationService.generateCorrespondenceDocumentAndAttach(correspondence);
    }
       
    
    
    protected void performDisapprove(ProtocolBase protocol) throws Exception {
        if (protocol.getProtocolDocument() != null) {
            WorkflowDocument currentWorkflowDocument = protocol.getProtocolDocument().getDocumentHeader().getWorkflowDocument();
            if (currentWorkflowDocument != null) {
                currentWorkflowDocument.disapprove("ProtocolBase document disapproved after committee decision");
            }
        }        
    }
    
    
    protected ProtocolDocumentBase getReturnedVersionedDocument(ProtocolBase protocol) throws Exception {
        documentService.cancelDocument(protocol.getProtocolDocument(), "ProtocolBase document cancelled - protocol has been returned for revisions.");        
        return getVersionedDocument(protocol);
    }
    
    


    @Override
    public void recordDisapprovedInRoutingActionAndUpdateStatuses(ProtocolBase protocol, ActionTakenValue latestCurrentActionTakenVal) {
        // add the action to the action history
        ProtocolActionBase protocolAction = getNewDisapprovedInRoutingProtocolActionInstanceHook(protocol);
        protocolAction.setComments(latestCurrentActionTakenVal.getAnnotation());
        protocolAction.setActionDate(latestCurrentActionTakenVal.getActionDate());
        protocol.getProtocolActions().add(protocolAction);
        // update the statuses and persist the protocol
        protocol.setProtocolStatusCode(getDisapprovedProtocolStatusCodeHook());
        protocol.refreshReferenceObject(Constants.PROPERTY_PROTOCOL_STATUS);
        protocol.getProtocolSubmission().setSubmissionStatusCode(getProtocolSubmissionStatusRejectedInRoutingCodeHook());
        protocol.refreshReferenceObject(PROTOCOL_SUBMISSION);
        this.getBusinessObjectService().save(protocol);
    }
    
    protected abstract String getProtocolSubmissionStatusRejectedInRoutingCodeHook();

    protected abstract String getDisapprovedProtocolStatusCodeHook();

    protected abstract ProtocolActionBase getNewDisapprovedInRoutingProtocolActionInstanceHook(ProtocolBase protocol);


    @Override
    public ProtocolDocumentBase versionAfterDisapprovalInRouting(ProtocolBase oldProtocol) throws Exception {
        // the new document version will be persisted along with the new version of the old protocol instance
        ProtocolDocumentBase newDocument = getVersionedDocument(oldProtocol);
        
        // set the 'pending/in progress' status for the new protocol 
        ProtocolBase newProtocol = newDocument.getProtocol();
        newProtocol.setProtocolStatusCode(getProtocolPendingInProgressStatusCodeHook());
        newProtocol.refreshReferenceObject(Constants.PROPERTY_PROTOCOL_STATUS);
        
        // set the submission status to disapproved in routing
        newProtocol.getProtocolSubmission().setSubmissionStatusCode(getProtocolSubmissionStatusRejectedInRoutingCodeHook());
        newProtocol.refreshReferenceObject(PROTOCOL_SUBMISSION);
        // finally save the protocol (and its submission)
        this.getBusinessObjectService().save(newProtocol);
        documentService.saveDocument(newDocument);
        
        return newDocument;
    }
    

    protected abstract String getProtocolPendingInProgressStatusCodeHook();


    
    protected ProtocolDocumentBase getVersionedDocument(ProtocolBase protocol) throws Exception {
        ProtocolDocumentBase newDocument = protocolVersionService.versionProtocolDocument(protocol.getProtocolDocument());
        newDocument.getProtocol().setProtocolSubmission(null);
        if(!protocol.isAmendment()) {
            newDocument.getProtocol().setApprovalDate(null);
            newDocument.getProtocol().setLastApprovalDate(null);
            newDocument.getProtocol().setExpirationDate(null);
        }        
        newDocument.getProtocol().refreshReferenceObject(Constants.PROPERTY_PROTOCOL_STATUS); 
        newDocument.getProtocol().refreshReferenceObject(PROTOCOL_SUBMISSION);
        documentService.saveDocument(newDocument);
        
        return newDocument;
    }
    
    protected abstract String getRecallProtocolActionTypeCodeHook();
    
    public void recall(ProtocolBase protocol) {
        ProtocolActionBase protocolAction = getNewProtocolActionInstanceHook(protocol, null, getRecallProtocolActionTypeCodeHook());
        protocolAction.setComments("Recalled in Routing");
        protocol.getProtocolActions().add(protocolAction);
        getProtocolActionService().updateProtocolStatus(protocolAction, protocol);
    }

    public void setProtocolActionService(ProtocolActionService protocolActionService) {
        this.protocolActionService = protocolActionService;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }
  
    public void setProtocolActionCorrespondenceGenerationService(ProtocolActionCorrespondenceGenerationService protocolActionCorrespondenceGenerationService) {
        this.protocolActionCorrespondenceGenerationService = protocolActionCorrespondenceGenerationService;
    }

    public void setProtocolOnlineReviewService(ProtocolOnlineReviewService protocolOnlineReviewService) {
        this.protocolOnlineReviewService = protocolOnlineReviewService;
    }

    public void setProtocolVersionService(ProtocolVersionService protocolVersionService) {
        this.protocolVersionService = protocolVersionService;
    }

    public void setProtocolAssignToAgendaService(ProtocolAssignToAgendaService protocolAssignToAgendaService) {
        this.protocolAssignToAgendaService = protocolAssignToAgendaService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }
    
    public void setKcNotificationService(KcNotificationService kcNotificationService) {
        this.kcNotificationService = kcNotificationService;
    }




    protected ProtocolActionService getProtocolActionService() {
        return protocolActionService;
    }




    protected DocumentService getDocumentService() {
        return documentService;
    }




    protected ProtocolActionCorrespondenceGenerationService getProtocolActionCorrespondenceGenerationService() {
        return protocolActionCorrespondenceGenerationService;
    }




    protected ProtocolOnlineReviewService getProtocolOnlineReviewService() {
        return protocolOnlineReviewService;
    }




    protected ProtocolVersionService getProtocolVersionService() {
        return protocolVersionService;
    }




    protected ProtocolAssignToAgendaService getProtocolAssignToAgendaService() {
        return protocolAssignToAgendaService;
    }




    protected BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }




    protected KcNotificationService getKcNotificationService() {
        return kcNotificationService;
    }

}
