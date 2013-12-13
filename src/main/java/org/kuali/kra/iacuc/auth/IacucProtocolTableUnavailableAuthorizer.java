/*
 * Copyright 2005-2010 The Kuali Foundation
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
package org.kuali.kra.iacuc.auth;

import org.kuali.kra.iacuc.actions.IacucProtocolActionType;
import org.kuali.kra.infrastructure.PermissionConstants;

/**
 * Determine if a user can assign a protocol to a committee/schedule and the action is currently not available.
 */
public class IacucProtocolTableUnavailableAuthorizer extends IacucProtocolTableAuthorizerBase {


    public boolean isAuthorized(String userId, IacucProtocolTask task) {
        return !( 
                  canExecuteAction(task.getProtocol(), IacucProtocolActionType.TABLED) &&
                  checkIfSubmissionCanBeBumped(task.getProtocol())
                 ) &&
               hasPermission(userId, task.getProtocol(), PermissionConstants.PERFORM_IACUC_ACTIONS_ON_PROTO);
    }

    
}