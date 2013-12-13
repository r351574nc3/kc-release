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
package org.kuali.kra.meeting;

import org.kuali.kra.common.committee.meeting.ModifyScheduleAuthorizerBase;
import org.kuali.kra.infrastructure.PermissionConstants;

public class ModifyScheduleAuthorizer extends ModifyScheduleAuthorizerBase {

    @Override
    protected String getModfifySchedulePermissionNameHook() {
        return PermissionConstants.MODIFY_SCHEDULE;
    }

// TODO ********************** commented out during IRB backfit ************************    
//    /**
//     * @see org.kuali.kra.irb.document.authorizer.CommitteeAuthorizer#isAuthorized(java.lang.String, org.kuali.kra.irb.document.authorization.CommitteeTask)
//     */
//    public boolean isAuthorized(String username, CommitteeTask task) {
//        boolean hasPermission = true;
//        Committee committee = task.getCommittee();
//        hasPermission = hasPermission(username, committee, PermissionConstants.MODIFY_SCHEDULE);
//        return hasPermission;
//    }

}
