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
package org.kuali.kra.iacuc.onlinereview.authorization;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolReviewerType;
import org.kuali.kra.iacuc.onlinereview.IacucProtocolOnlineReview;
import org.kuali.kra.infrastructure.KraServiceLocator;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.protocol.ProtocolOnlineReviewDocument;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReview;
import org.kuali.kra.protocol.onlinereview.authorization.ProtocolOnlineReviewTask;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.service.DocumentService;

public class ModifyIacucProtocolOnlineReviewDeterminationAuthorizer extends IacucProtocolOnlineReviewAuthorizer {

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(ModifyIacucProtocolOnlineReviewDeterminationAuthorizer.class);
    /**
     * @see org.kuali.kra.protocol.auth.ProtocolAuthorizer#isAuthorized(java.lang.String, org.kuali.kra.protocol.auth.ProtocolTask)
     */
    public boolean isAuthorized(String userId, IacucProtocolOnlineReviewTask task) {
        boolean hasPermission = false;
        IacucProtocolOnlineReview protocolOnlineReview = (IacucProtocolOnlineReview) task.getProtocolOnlineReview();
        ProtocolOnlineReviewDocument protocolDoc = null;
        try {
            protocolDoc = (ProtocolOnlineReviewDocument)KraServiceLocator.getService(DocumentService.class).getByDocumentHeaderId(protocolOnlineReview.getProtocolOnlineReviewDocument().getDocumentNumber());
            
            if ( protocolOnlineReview.getProtocolOnlineReviewId() != null 
                    && !protocolOnlineReview.getProtocolOnlineReviewDocument().isViewOnly()) {
                if (hasPermission(userId, protocolOnlineReview, PermissionConstants.MAINTAIN_IACUC_ONLINE_REVIEWS) 
                        && !protocolDoc.getDocumentHeader().getWorkflowDocument().isFinal()) {
                    hasPermission = true;
                } else if (hasPermission(userId, protocolOnlineReview, PermissionConstants.MAINTAIN_IACUC_PROTOCOL_ONLINE_REVIEW_COMMENTS)
                        && kraWorkflowService.isUserApprovalRequested(protocolDoc, userId)) {
                    String reviewerTypeCode = protocolOnlineReview.getProtocolReviewer().getReviewerTypeCode();
                    if (StringUtils.equals(reviewerTypeCode, IacucProtocolReviewerType.PRIMARY)
                            || StringUtils.equals(reviewerTypeCode, IacucProtocolReviewerType.SECONDARY)) {
                        hasPermission = true;
                    } else if (StringUtils.equals(reviewerTypeCode, IacucProtocolReviewerType.COMMITTEE)) {
                        if (protocolOnlineReview.getDeterminationReviewDateDue() != null) {
                            Calendar today = Calendar.getInstance();
                            Calendar typeDueDate = Calendar.getInstance();
                            typeDueDate.setTime(protocolOnlineReview.getDeterminationReviewDateDue());
                            hasPermission = typeDueDate.before(today);
                        } else {
                            hasPermission = true;
                        }
                    }
                }
            }
        }
        catch (WorkflowException e) {
            LOG.error(String.format("Could not find ProtocolOnlineReview, document number %s",protocolOnlineReview.getProtocolOnlineReviewDocument().getDocumentNumber()));
        }
        return hasPermission;
    }

}
