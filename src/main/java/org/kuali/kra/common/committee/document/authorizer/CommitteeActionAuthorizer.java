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
package org.kuali.kra.common.committee.document.authorizer;

import org.apache.commons.lang.StringUtils;
import org.kuali.kra.common.committee.bo.CommonCommittee;
import org.kuali.kra.common.committee.document.authorization.CommitteeTask;
import org.kuali.kra.common.committee.service.CommonCommitteeService;
import org.kuali.kra.infrastructure.PermissionConstants;

/**
 * The Committee Action Authorizer checks to see if the user has 
 * permission to perform committee actions. 
 */
public class CommitteeActionAuthorizer extends CommitteeAuthorizer {
    
    private CommonCommitteeService committeeService;

    /**
     * @see org.kuali.kra.protocol.document.authorizer.CommitteeAuthorizer#isAuthorized(java.lang.String, org.kuali.kra.protocol.document.authorization.CommitteeTask)
     */
    public boolean isAuthorized(String userId, CommitteeTask task) {
        CommonCommittee committee = task.getCommittee();
        return StringUtils.equals(committee.getCommitteeDocument().getDocumentHeader().getWorkflowDocument().getStatus().getLabel(), "FINAL")
                && committee.getCommitteeId() != null
                && committeeService.getCommitteeById(committee.getCommitteeId()).getId().equals(committee.getId())
                && hasPermission(userId, committee, PermissionConstants.PERFORM_IACUC_COMMITTEE_ACTIONS);
    }
    
    /**
     * Set the Committee Service.  Usually injected by the Spring Framework.
     * @param committeeService
     */
    public void setCommitteeService(CommonCommitteeService committeeService) {
        this.committeeService = committeeService;
    }

}
