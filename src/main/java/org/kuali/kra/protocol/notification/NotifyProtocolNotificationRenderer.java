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
package org.kuali.kra.protocol.notification;

import java.util.Map;

import org.kuali.kra.protocol.Protocol;

/**
 * Renders additional fields for the Notify IRB notification.
 */
public class NotifyProtocolNotificationRenderer extends ProtocolNotificationRenderer {

    private static final long serialVersionUID = -5315801471642797815L;
    
    private String actionComments;

    /**
     * Constructs a Notify IRB or IACUC notification renderer.
     * @param protocol
     * @param actionComments
     */
    public NotifyProtocolNotificationRenderer(Protocol protocol, String actionComments) {
        super(protocol);
        
        this.actionComments = actionComments;
    }
    
    public String getActionComments() {
        return actionComments;
    }

    public void setActionComments(String actionComments) {
        this.actionComments = actionComments;
    }
    
    /**
     * {@inheritDoc}
     * @see org.kuali.kra.common.notification.NotificationContext#replaceContextVariables(java.lang.String)
     */
    @Override
    public Map<String, String> getDefaultReplacementParameters() {
        Map<String, String> params = super.getDefaultReplacementParameters();
        params.put("{ACTION_COMMENTS}", getSafeMessage("{ACTION_COMMENTS}", actionComments));

        return params;
    }

}