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
package org.kuali.kra.proposaldevelopment.document.authorizer;

import org.apache.commons.lang.StringUtils;
import org.kuali.kra.infrastructure.NarrativeRight;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.proposaldevelopment.bo.Narrative;
import org.kuali.kra.proposaldevelopment.document.ProposalDevelopmentDocument;
import org.kuali.kra.proposaldevelopment.document.authorization.ProposalTask;

public class PersonnelAttachmentReplaceAuthorizer extends ProposalAuthorizer {

    @Override
    public boolean isAuthorized(String userId, ProposalTask task) {
        ProposalDevelopmentDocument doc = task.getDocument();
        boolean result = false;
        if (doc.getDevelopmentProposal().getProposalState() != null) {
            boolean hasPerm = hasProposalPermission(userId, doc, PermissionConstants.MODIFY_NARRATIVE);
            boolean isInProgress = StringUtils.equalsIgnoreCase(doc.getDevelopmentProposal().getProposalState().getDescription(), "In Progress");
            boolean isApprovalPending = StringUtils.equalsIgnoreCase(doc.getDevelopmentProposal().getProposalState().getDescription(), "Approval Pending");
            result = hasPerm && (isInProgress || isApprovalPending);
        }
        return result;
    }

}
