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
package org.kuali.kra.common.committee.document.authorizer;

import org.kuali.kra.common.committee.document.authorization.CommitteeTaskBase;

/**
 * The View CommitteeBase Authorizer determines if a user has the right
 * to view a specific committee.
 */
public abstract class ViewCommitteeAuthorizerBase extends CommitteeAuthorizerBase {

    /**
     * @see org.kuali.kra.protocol.document.authorizer.CommitteeAuthorizerBase#isAuthorized(java.lang.String, org.kuali.kra.protocol.document.authorization.CommitteeTaskBase)
     */
    public boolean isAuthorized(String userId, CommitteeTaskBase task) {
        
// TODO *********commented the code below during IACUC refactoring********* 
//        return hasPermission(userId, task.getCommittee(), PermissionConstants.VIEW__COMMITTEE);
        
        return hasPermission(userId, task.getCommittee(), getPermissionNameForViewCommitteeHook());
    }

    protected abstract String getPermissionNameForViewCommitteeHook();
    
}
