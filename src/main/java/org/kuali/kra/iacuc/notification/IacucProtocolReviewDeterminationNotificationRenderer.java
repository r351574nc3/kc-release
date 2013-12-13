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
package org.kuali.kra.iacuc.notification;

import java.text.SimpleDateFormat;
import java.util.Map;
import java.sql.Date;

import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.notification.IacucProtocolNotificationRenderer;
import org.kuali.kra.protocol.actions.delete.ProtocolDeleteBean;

/**
 * Renders additional fields for the Protocol Disapproved notification.
 */
public class IacucProtocolReviewDeterminationNotificationRenderer extends IacucProtocolNotificationRenderer {

    private Date dueDate;
    
    /**
     * Constructs a Protocol Review Type Determination notification renderer.
     * @param protocol
     * @param dueDate
     */
    public IacucProtocolReviewDeterminationNotificationRenderer(IacucProtocol protocol, Date dueDate) {
        super(protocol);
        this.dueDate = dueDate;
    }
    
    /**
     * {@inheritDoc}
     * @see org.kuali.kra.common.notification.NotificationContext#replaceContextVariables(java.lang.String)
     */
    @Override
    public Map<String, String> getDefaultReplacementParameters() {
        Map<String, String> params = super.getDefaultReplacementParameters();
        params.put("{DUE_DATE}", (dueDate == null ? "N/A" : new SimpleDateFormat("d'-'MMM'-'yyyy").format(dueDate)));
        return params;
    }

}