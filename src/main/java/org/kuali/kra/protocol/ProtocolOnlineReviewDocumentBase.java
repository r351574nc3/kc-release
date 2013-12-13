/*
 * Copyright 2005-2013 The Kuali Foundation
 * 
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.osedu.org/licenses/ECL-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kuali.kra.protocol;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.kuali.kra.bo.RolePersons;
import org.kuali.kra.document.ResearchDocumentBase;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KraServiceLocator;
import org.kuali.kra.protocol.actions.reviewcomments.ReviewCommentsService;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewBase;
import org.kuali.kra.service.KraAuthorizationService;
import org.kuali.rice.coreservice.framework.parameter.ParameterConstants;
import org.kuali.rice.coreservice.framework.parameter.ParameterConstants.COMPONENT;
import org.kuali.rice.coreservice.framework.parameter.ParameterConstants.NAMESPACE;
import org.kuali.rice.kew.framework.postprocessor.ActionTakenEvent;
import org.kuali.rice.kew.framework.postprocessor.DocumentRouteStatusChange;
import org.kuali.rice.krad.document.Copyable;
import org.kuali.rice.krad.document.SessionDocument;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.DocumentService;
import org.kuali.rice.krad.service.KRADServiceLocatorWeb;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.ObjectUtils;
import org.kuali.rice.krad.workflow.service.WorkflowDocumentService;

/**
 * 
 * This class represents the ProtocolBase Review Document Object.
 * ProtocolReviewDocument has a 1:1 relationship with ProtocolReview Business Object.
 * We have declared a list of ProtocolBase BOs in the ProtocolDocumentBase at the same time to
 * get around the OJB anonymous keys issue of primary keys of different data types.
 * Also we have provided convenient getter and setter methods so that to the outside world;
 * ProtocolBase and ProtocolDocumentBase can have a 1:1 relationship.
 */
@NAMESPACE(namespace=Constants.MODULE_NAMESPACE_PROTOCOL)
@COMPONENT(component=ParameterConstants.DOCUMENT_COMPONENT)
public abstract class ProtocolOnlineReviewDocumentBase extends ResearchDocumentBase implements Copyable, SessionDocument { 
	
    private static final String DOCUMENT_TYPE_CODE = "PTRV";
    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(ProtocolOnlineReviewDocumentBase.class);
    private static final String OLR_DOC_ID_PARAM = "olrDocId";
    private static final String OLR_EVENT_PARAM = "olrEvent";

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 803158468103165087L;

    /**
     * Constructs a ProtocolDocumentBase object
     */
	public ProtocolOnlineReviewDocumentBase() { 
        super();
	} 
	
    public void initialize() {
        super.initialize();
    }

    
    /**
     * 
     * This method is a convenience method for facilitating a 1:1 relationship between ProtocolDocumentBase 
     * and ProtocolBase to the outside world - aka a single ProtocolBase field associated with ProtocolDocumentBase
     * @return
     */
    public abstract ProtocolOnlineReviewBase getProtocolOnlineReview();
 
    /**
     * 
     * This method is a convenience method for facilitating a 1:1 relationship between ProtocolDocumentBase 
     * and ProtocolBase to the outside world - aka a single ProtocolBase field associated with ProtocolDocumentBase
     * @param protocol
     */
     public abstract void setProtocolOnlineReview(ProtocolOnlineReviewBase protocolOnlineReview);

     /**
     * @see org.kuali.kra.document.ResearchDocumentBase#getAllRolePersons()
     */
    @Override
    protected List<RolePersons> getAllRolePersons() {
        KraAuthorizationService kraAuthService = 
               (KraAuthorizationService) KraServiceLocator.getService(KraAuthorizationService.class); 
        return new ArrayList<RolePersons>();
    }
    
    public String getDocumentTypeCode() {
        return DOCUMENT_TYPE_CODE;
    }
    
    
    /**
     * @see org.kuali.rice.krad.document.DocumentBase#doRouteStatusChange(org.kuali.rice.kew.framework.postprocessor.DocumentRouteStatusChange)
     */
    @Override
    public void doRouteStatusChange(DocumentRouteStatusChange statusChangeEvent) {
        super.doRouteStatusChange(statusChangeEvent);
    }
  
    /**
     * @see org.kuali.rice.krad.document.DocumentBase#doActionTaken(org.kuali.rice.kew.framework.postprocessor.ActionTakenEvent)
     */
    @Override
    public void doActionTaken( ActionTakenEvent event ) {
        super.doActionTaken(event);
    }
    
    private BusinessObjectService getBusinessObjectService() {
        return KraServiceLocator.getService(BusinessObjectService.class);
    }
    
    private ReviewCommentsService getReviewerCommentsService() {
        return KraServiceLocator.getService(ReviewCommentsService.class);
    }

    @Override
    public void prepareForSave() {
        super.prepareForSave();
        if (ObjectUtils.isNull(this.getVersionNumber())) {
            this.setVersionNumber(new Long(0));
        }
    }
    
    public boolean isProcessComplete() {
        boolean isComplete = true;
        
        String backLocation = (String) GlobalVariables.getUserSession().retrieveObject(Constants.HOLDING_PAGE_RETURN_LOCATION);
        String olrDocId = getURLParamValue(backLocation, OLR_DOC_ID_PARAM);
        if (olrDocId != null) {
            String olrEvent = getURLParamValue(backLocation, OLR_EVENT_PARAM);
            if (StringUtils.equalsIgnoreCase(olrEvent, "Approve")) {
                isComplete = isOnlineReviewApproveComplete(olrDocId);
            } else if (StringUtils.equalsIgnoreCase(olrEvent, "Reject")) {
                isComplete = isOnlineReviewRejectComplete(olrDocId);         
            }
        }
            
        return isComplete;
    }
  
    private WorkflowDocumentService getWorkflowDocumentService() {
        return KRADServiceLocatorWeb.getWorkflowDocumentService();
    }    

    private boolean isOnlineReviewApproveComplete(String olrDocId) {
        boolean isComplete = true;
        try {
            ProtocolOnlineReviewDocumentBase onlineReviewDoc = (ProtocolOnlineReviewDocumentBase)getDocumentService().getByDocumentHeaderId(olrDocId);
            if (getWorkflowDocumentService().getCurrentRouteNodeNames(onlineReviewDoc.getDocumentHeader().getWorkflowDocument()).equalsIgnoreCase(Constants.ONLINE_REVIEW_ROUTE_NODE_ONLINE_REVIEWER)) {
                isComplete = false;
            }
        } catch (Exception e) {
            isComplete = true;
        }
        
        return isComplete;
    }

    private boolean isOnlineReviewRejectComplete(String olrDocId) {
        boolean isComplete = true;
        try {
            ProtocolOnlineReviewDocumentBase onlineReviewDoc = (ProtocolOnlineReviewDocumentBase)getDocumentService().getByDocumentHeaderId(olrDocId);
            if (!getWorkflowDocumentService().getCurrentRouteNodeNames(onlineReviewDoc.getDocumentHeader().getWorkflowDocument()).equalsIgnoreCase(Constants.ONLINE_REVIEW_ROUTE_NODE_ONLINE_REVIEWER)) {
                isComplete = false;
            }
        } catch (Exception e) {
            isComplete = true;
        }
        
        return isComplete;
    }
    
    private DocumentService getDocumentService() {
        return KraServiceLocator.getService(DocumentService.class);
    }
    
    private String getURLParamValue(String url, String paramName) {
        String pValue = null;
        
        if (StringUtils.isNotBlank(url) && url.indexOf("?") > -1) {
            String paramString = url.substring(url.indexOf("?") + 1);

            if (StringUtils.isNotBlank(paramString)) {
                String params[] = paramString.split("&");
                for (String param : params) {
                    String temp[] = param.split("=");

                    if (StringUtils.equals(temp[0], paramName)) {
                        pValue = temp[1];
                    }
                }
            }
        }
        
        return pValue;
    }
}