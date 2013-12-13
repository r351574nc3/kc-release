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

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.kuali.kra.iacuc.IacucProtocol;

/**
 * Renders fields for the IACUC generic action notifications.
 */
public class IacucProtocolGenericActionNotificationRenderer extends IacucProtocolNotificationRenderer {

    private static final long serialVersionUID = 7161539104579479457L;

    private Date actionDate;
    
    /**
     * Constructs a Protocol base notification renderer.
     * @param protocol
     */
    public IacucProtocolGenericActionNotificationRenderer(IacucProtocol protocol, Date actionDate) {
        super(protocol);
        this.actionDate = actionDate;
    }

    /**
     * {@inheritDoc}
     * @see org.kuali.kra.common.notification.NotificationRenderer#getReplacementParameters()
     */
    public Map<String, String> getDefaultReplacementParameters() {
        Map<String, String> params = super.getDefaultReplacementParameters();
        params.put("{ACTION_DATE}",(new SimpleDateFormat("d'-'MMM'-'yyyy")).format(actionDate));
        return params;
    }
    
}
