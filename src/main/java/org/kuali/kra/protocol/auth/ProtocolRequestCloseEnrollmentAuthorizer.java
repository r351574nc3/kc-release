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
package org.kuali.kra.protocol.auth;

import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.irb.actions.ProtocolActionType;

/**
 * Is the user allowed to request a close of the enrollment of a protocol?
 */
public class ProtocolRequestCloseEnrollmentAuthorizer extends ProtocolAuthorizerBase {

    /**
     * @see org.kuali.kra.protocol.auth.ProtocolAuthorizerBase#isAuthorized(java.lang.String, org.kuali.kra.protocol.auth.ProtocolTaskBase)
     */
    public boolean isAuthorized(String userId, ProtocolTaskBase task) {
        return !isAmendmentOrRenewal(task.getProtocol()) &&
               canExecuteAction(task.getProtocol(), ProtocolActionType.REQUEST_TO_CLOSE_ENROLLMENT) &&
               hasPermission(userId, task.getProtocol(), PermissionConstants.SUBMIT_PROTOCOL);
    }
}
