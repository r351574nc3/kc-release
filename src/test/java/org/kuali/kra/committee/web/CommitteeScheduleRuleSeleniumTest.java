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
package org.kuali.kra.committee.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.test.infrastructure.KcSeleniumTestBase;

/**
 * Tests the rules on the Schedule page of a Committee.
 */
public class CommitteeScheduleRuleSeleniumTest extends KcSeleniumTestBase {
    
    private static final String TABLE_ID = "schedule-table";
    private static final String ERROR_TAB_ID = "tab-Schedule-div";
    
    private static final String HELPER_PREFIX = "committeeHelper.scheduleData.";
    private static final String LIST_PREFIX = "document.committeeList[0].committeeSchedules[%d].";
    
    private static final String SCHEDULE_START_DATE_ID = "scheduleStartDate";
    private static final String TIME_ID = "time.time";
    private static final String PLACE_ID = "place";
    private static final String RECURRENCE_TYPE_ID = "recurrenceType";
    private static final String DAILY_SCHEDULE_SCHEDULE_END_DATE_ID = "dailySchedule.scheduleEndDate";
    private static final String SCHEDULE_DATE_ID = "scheduledDate";
    private static final String PROTOCOL_SUB_DEADLINE_ID = "protocolSubDeadline";
    private static final String HELPER_SCHEDULE_START_DATE_ID = HELPER_PREFIX + SCHEDULE_START_DATE_ID;
    private static final String HELPER_TIME_ID = HELPER_PREFIX + TIME_ID;
    private static final String HELPER_PLACE_ID = HELPER_PREFIX + PLACE_ID;
    private static final String HELPER_RECURRENCE_TYPE_ID = HELPER_PREFIX + RECURRENCE_TYPE_ID;
    private static final String HELPER_DAILY_SCHEDULE_SCHEDULE_END_DATE_ID = HELPER_PREFIX + DAILY_SCHEDULE_SCHEDULE_END_DATE_ID;
    private static final String LIST_SCHEDULE_DATE_ID = LIST_PREFIX + SCHEDULE_DATE_ID;
    private static final String LIST_PROTOCOL_SUB_DEADLINE_ID = LIST_PREFIX + PROTOCOL_SUB_DEADLINE_ID; 
    
    private static final String TIME = "10:30";
    private static final String PLACE = "Sacramento";
    private static final String RECURRENCE_TYPE = "DAILY";
    
    private static final String ERROR_CONFLICT = " is in conflict with other meeting schedule";
    private static final String ERROR_DATE_RANGE = "End date must be after Start Date.";
    private static final String WARNING_SKIPPED = " is skipped in recurrence, meeting already scheduled for the date.";
    
    private static final String ADD_EVENT_BUTTON = "methodToCall.addEvent";
    
    private static final DateFormat fullFormatter = new SimpleDateFormat("MM/dd/yyyy");
    private static final DateFormat dayFormatter = new SimpleDateFormat("EEEE");
    private static final DateFormat errorFormatter = new SimpleDateFormat("yyyy-MM-dd");
    
    private CommitteeSeleniumHelper helper;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        
        helper = CommitteeSeleniumHelper.instance(driver);
    }
    
    @After
    public void tearDown() throws Exception {
        helper = null;
        
        super.tearDown();
    }
    
    /**
     * Test the date conflict rule.
     * 
     * @throws Exception
     */
    @Test
    public void testSchedulePanelDateConflict() throws Exception {
        helper.createCommittee();
        helper.clickCommitteeSchedulePage();
        
        Date scheduleStartDate = DateUtils.addDays(new Date(), -1);
        Date scheduleEndDate = DateUtils.addDays(scheduleStartDate, 2);
        
        helper.set(HELPER_SCHEDULE_START_DATE_ID, fullFormatter.format(scheduleStartDate));
        helper.set(HELPER_TIME_ID, TIME);      
        helper.set(HELPER_PLACE_ID, PLACE);
        helper.set(HELPER_RECURRENCE_TYPE_ID, RECURRENCE_TYPE);       
        helper.set(HELPER_DAILY_SCHEDULE_SCHEDULE_END_DATE_ID, fullFormatter.format(scheduleEndDate));
        
        helper.click(ADD_EVENT_BUTTON);
        helper.assertNoPageErrors();
        
        Date firstScheduleDate = DateUtils.addDays(scheduleStartDate, 0);
        Date firstDeadlineDate = DateUtils.addDays(firstScheduleDate, -1);
        Date secondScheduleDate = DateUtils.addDays(scheduleStartDate, 1);
        Date secondDeadlineDate = DateUtils.addDays(secondScheduleDate, -1);
        Date thirdScheduleDate = DateUtils.addDays(scheduleStartDate, 2);
        Date thirdDeadlineDate = DateUtils.addDays(thirdScheduleDate, -1);
        
        helper.assertTableRowCount(TABLE_ID, 6);
        
        helper.assertElementContains(String.format(LIST_SCHEDULE_DATE_ID, 0), fullFormatter.format(firstScheduleDate));
        helper.assertTableCellValueContains(TABLE_ID, 2, 1, dayFormatter.format(firstScheduleDate).toUpperCase());
        helper.assertElementContains(String.format(LIST_PROTOCOL_SUB_DEADLINE_ID, 0), fullFormatter.format(firstDeadlineDate));
        
        helper.assertElementContains(String.format(LIST_SCHEDULE_DATE_ID, 1), fullFormatter.format(secondScheduleDate));
        helper.assertTableCellValueContains(TABLE_ID, 3, 1, dayFormatter.format(secondScheduleDate).toUpperCase());
        helper.assertElementContains(String.format(LIST_PROTOCOL_SUB_DEADLINE_ID, 1), fullFormatter.format(secondDeadlineDate));
        
        helper.assertElementContains(String.format(LIST_SCHEDULE_DATE_ID, 2), fullFormatter.format(thirdScheduleDate));
        helper.assertTableCellValueContains(TABLE_ID, 4, 1, dayFormatter.format(thirdScheduleDate).toUpperCase());
        helper.assertElementContains(String.format(LIST_PROTOCOL_SUB_DEADLINE_ID, 2), fullFormatter.format(thirdDeadlineDate));
        
        Date newScheduleDate = DateUtils.addDays(scheduleStartDate, 1);
    
        helper.set(String.format(LIST_SCHEDULE_DATE_ID, 0), fullFormatter.format(newScheduleDate));              
        
        helper.saveDocument();
        helper.assertPageErrors();
        
        helper.assertError(ERROR_TAB_ID, errorFormatter.format(newScheduleDate) + ERROR_CONFLICT);
    }     

    /**
     * Test the start and end date rule.
     * 
     * @throws Exception
     */
     @Test
     public void testStartDateEndDateRule() throws Exception {
         helper.createCommittee();
         helper.clickCommitteeSchedulePage();
         
         Date scheduleStartDate = new Date();
         Date scheduleEndDate = scheduleStartDate;
         
         helper.set(HELPER_SCHEDULE_START_DATE_ID, fullFormatter.format(scheduleStartDate));
         helper.set(HELPER_TIME_ID, TIME);      
         helper.set(HELPER_PLACE_ID, PLACE);
         helper.set(HELPER_RECURRENCE_TYPE_ID, RECURRENCE_TYPE);      
         helper.set(HELPER_DAILY_SCHEDULE_SCHEDULE_END_DATE_ID, fullFormatter.format(scheduleEndDate));

         helper.click(ADD_EVENT_BUTTON);
         helper.assertPageErrors();
         
         helper.assertError(ERROR_TAB_ID, ERROR_DATE_RANGE);
     }
        
    /**
     * Test the warning message during date conflict.
     * 
     * @throws Exception
     */
    @Test
    public void testDateWarnings() throws Exception {
        helper.createCommittee();
        helper.clickCommitteeSchedulePage();
        
        Date scheduleStartDate = DateUtils.addDays(new Date(), -1);
        Date scheduleEndDate = DateUtils.addDays(scheduleStartDate, 2);
        
        helper.set(HELPER_SCHEDULE_START_DATE_ID, fullFormatter.format(scheduleStartDate));
        helper.set(HELPER_TIME_ID, TIME);      
        helper.set(HELPER_PLACE_ID, PLACE);
        helper.set(HELPER_RECURRENCE_TYPE_ID, RECURRENCE_TYPE);       
        helper.set(HELPER_DAILY_SCHEDULE_SCHEDULE_END_DATE_ID, fullFormatter.format(scheduleEndDate));
        
        helper.click(ADD_EVENT_BUTTON);
        helper.assertNoPageErrors();
        
        Date firstScheduleDate = DateUtils.addDays(scheduleStartDate, 0);
        Date firstDeadlineDate = DateUtils.addDays(firstScheduleDate, -1);
        Date secondScheduleDate = DateUtils.addDays(scheduleStartDate, 1);
        Date secondDeadlineDate = DateUtils.addDays(secondScheduleDate, -1);
        Date thirdScheduleDate = DateUtils.addDays(scheduleStartDate, 2);
        Date thirdDeadlineDate = DateUtils.addDays(thirdScheduleDate, -1);
        
        helper.assertTableRowCount(TABLE_ID, 6);
        
        helper.assertElementContains(String.format(LIST_SCHEDULE_DATE_ID, 0), fullFormatter.format(firstScheduleDate));
        helper.assertTableCellValueContains(TABLE_ID, 2, 1, dayFormatter.format(firstScheduleDate).toUpperCase());
        helper.assertElementContains(String.format(LIST_PROTOCOL_SUB_DEADLINE_ID, 0), fullFormatter.format(firstDeadlineDate));
        
        helper.assertElementContains(String.format(LIST_SCHEDULE_DATE_ID, 1), fullFormatter.format(secondScheduleDate));
        helper.assertTableCellValueContains(TABLE_ID, 3, 1, dayFormatter.format(secondScheduleDate).toUpperCase());
        helper.assertElementContains(String.format(LIST_PROTOCOL_SUB_DEADLINE_ID, 1), fullFormatter.format(secondDeadlineDate));
        
        helper.assertElementContains(String.format(LIST_SCHEDULE_DATE_ID, 2), fullFormatter.format(thirdScheduleDate));
        helper.assertTableCellValueContains(TABLE_ID, 4, 1, dayFormatter.format(thirdScheduleDate).toUpperCase());
        helper.assertElementContains(String.format(LIST_PROTOCOL_SUB_DEADLINE_ID, 2), fullFormatter.format(thirdDeadlineDate));
               
        helper.click(ADD_EVENT_BUTTON);
        helper.assertNoPageErrors();
        
        helper.assertWarning(ERROR_TAB_ID, errorFormatter.format(scheduleStartDate) + WARNING_SKIPPED);
    }
   
}