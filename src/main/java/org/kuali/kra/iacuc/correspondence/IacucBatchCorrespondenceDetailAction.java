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
package org.kuali.kra.iacuc.correspondence;

import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.protocol.correspondence.BatchCorrespondence;
import org.kuali.kra.protocol.correspondence.BatchCorrespondenceDetail;
import org.kuali.kra.protocol.correspondence.BatchCorrespondenceDetailAction;
import org.kuali.kra.protocol.correspondence.BatchCorrespondenceDetailAuthorizationService;
import org.kuali.kra.protocol.correspondence.BatchCorrespondenceDetailForm;
import org.kuali.kra.protocol.correspondence.BatchCorrespondenceDetailRule;
import org.kuali.kra.protocol.correspondence.BatchCorrespondenceDetailService;

public class IacucBatchCorrespondenceDetailAction extends BatchCorrespondenceDetailAction {

    @Override
    protected BatchCorrespondenceDetailForm getNewBatchCorrespondenceDetailFormInstanceHook() {
        return new IacucBatchCorrespondenceDetailForm();
    }

    @Override
    protected BatchCorrespondenceDetail getNewBatchCorrespondenceDetailInstanceHook() {
        return new IacucBatchCorrespondenceDetail();
    }

    @Override
    protected String getViewBatchCorrespondenceDetailPermissionNameHook() {
        return PermissionConstants.VIEW_IACUC_BATCH_CORRESPONDENCE_DETAIL;
    }

    @Override
    protected String getModifyBatchCorrespondenceDetailPermissionNameHook() {
        return PermissionConstants.MODIFY_IACUC_BATCH_CORRESPONDENCE_DETAIL;
    }

    @Override
    protected Class<? extends BatchCorrespondence> getBatchCorrespondenceClassHook() {
        return IacucBatchCorrespondence.class;
    }

    @Override
    protected BatchCorrespondenceDetailRule getNewInstanceOfBatchCorrespondenceDetailRuleHook() {
        return new IacucBatchCorrespondenceDetailRule();
    }

    @Override
    protected Class<? extends BatchCorrespondenceDetailService> getBatchCorrespondenceDetailServiceClassHook() {
        return IacucBatchCorrespondenceDetailService.class; 
    }

    @Override
    protected Class<? extends BatchCorrespondenceDetailAuthorizationService> getBatchCorrespondenceDetailAuthorizationServiceClassHook() {
        return IacucBatchCorrespondenceDetailAuthorizationService.class;
    }

}
