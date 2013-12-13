/*
 * Copyright 2005-2010 The Kuali Foundation
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
package org.kuali.kra.iacuc.actions.withdraw;

import java.sql.Date;

import org.apache.commons.lang.StringUtils;
import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.iacuc.actions.IacucProtocolAction;
import org.kuali.kra.iacuc.actions.IacucProtocolActionType;
import org.kuali.kra.iacuc.actions.IacucProtocolStatus;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolSubmissionStatus;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolSubmissionType;
import org.kuali.kra.protocol.actions.ProtocolAction;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmission;
import org.kuali.kra.protocol.Protocol;
import org.kuali.kra.protocol.ProtocolDocument;
import org.kuali.kra.protocol.actions.withdraw.ProtocolAdministrativelyIncompleteBean;
import org.kuali.kra.protocol.actions.withdraw.ProtocolAdministrativelyWithdrawBean;
import org.kuali.kra.protocol.actions.withdraw.ProtocolWithdrawBean;
import org.kuali.kra.protocol.actions.withdraw.ProtocolWithdrawServiceImpl;




public class IacucProtocolWithdrawServiceImpl extends ProtocolWithdrawServiceImpl implements IacucProtocolWithdrawService {
    
    @Override
    public ProtocolDocument administrativelyMarkIncomplete(Protocol protocol, ProtocolAdministrativelyIncompleteBean markIncompleteBean) throws Exception {
        String protocolWithdrawnActionTypeCode = IacucProtocolActionType.ADMINISTRATIVELY_INCOMPLETE;
        String protocolWithdrawnStatusCode = IacucProtocolStatus.ADMINISTRATIVELY_INCOMPLETE;
        String protocolWithdrawnSubmissionStatusCode = IacucProtocolSubmissionStatus.ADMINISTRATIVELY_INCOMPLETE;
        return this.commonWithdrawLogic(protocol, markIncompleteBean, protocolWithdrawnActionTypeCode, protocolWithdrawnStatusCode, protocolWithdrawnSubmissionStatusCode);
    }

    
    @Override
    public ProtocolDocument administrativelyWithdraw(Protocol protocol, ProtocolAdministrativelyWithdrawBean administrativelyWithdrawBean) throws Exception {
        String protocolWithdrawnActionTypeCode = IacucProtocolActionType.ADMINISTRATIVELY_WITHDRAWN;
        String protocolWithdrawnStatusCode = IacucProtocolStatus.ADMINISTRATIVELY_WITHDRAWN;
        String protocolWithdrawnSubmissionStatusCode = IacucProtocolSubmissionStatus.WITHDRAWN;
        return this.commonWithdrawLogic(protocol, administrativelyWithdrawBean, protocolWithdrawnActionTypeCode, protocolWithdrawnStatusCode, protocolWithdrawnSubmissionStatusCode);
    }
    
    
    @Override
    public ProtocolDocument withdraw(Protocol protocol, ProtocolWithdrawBean withdrawBean) throws Exception {
        String protocolWithdrawnActionTypeCode = IacucProtocolActionType.IACUC_WITHDRAWN;
        String protocolWithdrawnStatusCode = IacucProtocolStatus.WITHDRAWN;
        String protocolWithdrawnSubmissionStatusCode = IacucProtocolSubmissionStatus.WITHDRAWN; 
        return this.commonWithdrawLogic(protocol, withdrawBean,  protocolWithdrawnActionTypeCode, protocolWithdrawnStatusCode, protocolWithdrawnSubmissionStatusCode);
    }
    

    
    // the common withdrawal logic used by three service methods above
    private ProtocolDocument commonWithdrawLogic(Protocol protocol, 
                                                 ProtocolWithdrawBean withdrawBean, 
                                                 String protocolWithdrawnActionTypeCode,
                                                 String protocolWithdrawnStatusCode,
                                                 String protocolWithdrawnSubmissionStatusCode) throws Exception {        
        
        ProtocolSubmission submission = getSubmission(protocol);
        ProtocolAction protocolAction = new IacucProtocolAction((IacucProtocol) protocol, null, protocolWithdrawnActionTypeCode);
        protocolAction.setComments(withdrawBean.getReason());
        protocol.getProtocolActions().add(protocolAction);

        boolean isVersion = IacucProtocolStatus.IN_PROGRESS.equals(protocol.getProtocolStatusCode()) ||
                            IacucProtocolStatus.SUBMITTED_TO_IACUC.equals(protocol.getProtocolStatusCode()) ||
                            IacucProtocolStatus.TABLED.equals(protocol.getProtocolStatusCode());
        
        protocolActionService.updateProtocolStatus(protocolAction, protocol);

        if (submission != null) {
            submission.setSubmissionDate(new Date(System.currentTimeMillis()));
            submission.setSubmissionStatusCode(protocolWithdrawnSubmissionStatusCode);
            // need to finalize any outstanding review documents.
            
// TODO *********commented the code below during IACUC refactoring*********             
//            protocolOnlineReviewService.finalizeOnlineReviews(submission, WITHDRAW_FINALIZE_OLR_ANNOTATION);
            
        }
        businessObjectService.save(protocol.getProtocolDocument());
 
        if (isVersion) {
            /*
             * Cancelling the workflow document is how we withdraw it.
             */
            cancelWorkflow(protocol);
            
            /*
             * Create a new protocol document for the user to edit so they can re-submit at a later time.
             */
            IacucProtocolDocument newProtocolDocument = (IacucProtocolDocument) protocolVersionService.versionProtocolDocument(protocol.getProtocolDocument());
            newProtocolDocument.getProtocol().setProtocolStatusCode(protocolWithdrawnStatusCode);
            // to force it to retrieve from list.
            newProtocolDocument.getProtocol().setProtocolSubmission(null);
            // update some info
            newProtocolDocument.getProtocol().setApprovalDate(null);
            newProtocolDocument.getProtocol().setLastApprovalDate(null);
            newProtocolDocument.getProtocol().setExpirationDate(null);

            newProtocolDocument.getProtocol().refreshReferenceObject("protocolStatus");
            documentService.saveDocument(newProtocolDocument);

            // if there is an assign to agenda protocol action, remove it.
// TODO *********commented the code below during IACUC refactoring*********             
//            ProtocolAction assignToAgendaProtocolAction = protocolAssignToAgendaService
//                    .getAssignedToAgendaProtocolAction(newProtocolDocument.getProtocol());
//            if (assignToAgendaProtocolAction != null) {
//                newProtocolDocument.getProtocol().getProtocolActions().remove(assignToAgendaProtocolAction);
//                businessObjectService.delete(assignToAgendaProtocolAction);
//            }
            
            newProtocolDocument.getProtocol().refreshReferenceObject("protocolStatus");
            documentService.saveDocument(newProtocolDocument);             
            generateCorrespondenceDocumentAndAttach(newProtocolDocument.getProtocol(), withdrawBean);
            
            return newProtocolDocument;
        }
        
// This is withdraw submission not protocol.  the withdraw correspondence is for 'protocol' now.
// it's not suitable for withdraw protocol submission.
        
        else {        
            generateCorrespondenceDocumentAndAttach(protocol, withdrawBean);
        }
        
        return protocol.getProtocolDocument();
    }
    
    
    
    
    /**
     * Does the submission status allow us to withdraw the protocol?
     * @param submission
     * @return true if withdrawable; otherwise false
     */
    protected boolean isAllowedStatus(ProtocolSubmission submission) {
        return StringUtils.equals(submission.getSubmissionStatusCode(), IacucProtocolSubmissionStatus.PENDING) ||
               StringUtils.equals(submission.getSubmissionStatusCode(), IacucProtocolSubmissionStatus.SUBMITTED_TO_COMMITTEE);
    }
    
    /**
     * Does the submission type allow us to withdraw the protocol?
     * @param submission
     * @return true if withdrawable; otherwise false
     */
    protected boolean isNormalSubmission(ProtocolSubmission submission) {
        return StringUtils.equals(submission.getSubmissionTypeCode(), IacucProtocolSubmissionType.AMENDMENT) ||
               StringUtils.equals(submission.getSubmissionTypeCode(), IacucProtocolSubmissionType.INITIAL_SUBMISSION) ||
               StringUtils.equals(submission.getSubmissionTypeCode(), IacucProtocolSubmissionType.CONTINUATION) ||
               StringUtils.equals(submission.getSubmissionTypeCode(), IacucProtocolSubmissionType.CONTINUATION_WITH_AMENDMENT);
    }

    


}
