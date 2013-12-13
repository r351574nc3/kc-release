/*.
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
package org.kuali.kra.subaward.document.authorizer;

import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.subaward.bo.SubAward;
import org.kuali.kra.subaward.document.SubAwardDocument;
import org.kuali.kra.subaward.document.authorization.SubAwardTask;

/**
 * This class checks the authorization for modifySubAward...
 */
public class ModifySubAwardAutherizer extends SubAwardAuthorizer {

    @Override
    public boolean isAuthorized(String userId, SubAwardTask task) {

        SubAwardDocument subAwardDocument = task.getSubAwardDocument();
        if (subAwardDocument.getSubAward().getSubAwardId() != null) {

            if (hasPermission(userId, task.getSubAwardDocument().
            getSubAward(), PermissionConstants.MODIFY_SUBAWARD)) {
                subAwardDocument.getSubAward().setEditSubAward(true);
            }
            return !subAwardDocument.isViewOnly()
            && hasPermission(userId, task.getSubAwardDocument().
            getSubAward(), PermissionConstants.MODIFY_SUBAWARD)
           && !kraWorkflowService.isInWorkflow(subAwardDocument);
        } else {
            return canUserCreateSubAward(
            userId, subAwardDocument.getSubAward());

        }
    }

    /**.
     * This method is for checking whether user can create subAward
     *@param award the SubAward
     *@param userId the userId
     *@return boolean
     */
 protected boolean canUserCreateSubAward(String userId, SubAward award) {
        return hasUnitPermission(userId, Constants.
        MODULE_NAMESPACE_SUBAWARD, PermissionConstants.CREATE_SUBAWARD);
    }
}
