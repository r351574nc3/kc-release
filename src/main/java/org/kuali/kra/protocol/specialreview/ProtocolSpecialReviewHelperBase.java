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
package org.kuali.kra.protocol.specialreview;

import org.kuali.kra.common.specialreview.web.struts.form.SpecialReviewHelperBase;
import org.kuali.kra.infrastructure.KraServiceLocator;
import org.kuali.kra.service.TaskAuthorizationService;

/**
 * Defines the Special Review Helper for ProtocolBase.
 */
public abstract class ProtocolSpecialReviewHelperBase extends SpecialReviewHelperBase<ProtocolSpecialReviewBase> {

    private static final long serialVersionUID = -6004130465079070854L;
    
    private transient TaskAuthorizationService taskAuthorizationService;
    
    
    public TaskAuthorizationService getTaskAuthorizationService() {
        if (taskAuthorizationService == null) {
            taskAuthorizationService = KraServiceLocator.getService(TaskAuthorizationService.class);
        }
        return taskAuthorizationService;
    }
    
    public void setTaskAuthorizationService(TaskAuthorizationService taskAuthorizationService) {
        this.taskAuthorizationService = taskAuthorizationService;
    }

}
