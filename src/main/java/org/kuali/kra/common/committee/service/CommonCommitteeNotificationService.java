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
package org.kuali.kra.common.committee.service;

import org.kuali.kra.common.committee.meeting.CommScheduleMinuteDocBase;
import org.kuali.kra.common.committee.meeting.ScheduleAgendaBase;


/**
 * 
 * This class generates committee-based notifications.
 */
public interface CommonCommitteeNotificationService {
    
    /**
     * 
     * These methods generate committee notifications
     * @throws Exception 
     */
    public void generateNotification(String notificationType, ScheduleAgendaBase agenda);
    public void generateNotification(String notificationType, CommScheduleMinuteDocBase minuteDoc);
 
}
