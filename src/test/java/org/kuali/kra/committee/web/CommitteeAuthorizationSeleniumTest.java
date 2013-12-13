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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.test.infrastructure.KcSeleniumTestBase;

/**
 * Test authorizations for Committee.
 */
public class CommitteeAuthorizationSeleniumTest extends KcSeleniumTestBase {
    
    private static final String CREATE_COMMITTEE_LINK_NAME = "Create Committee";
    
    private static final String ERROR_ID = "font[color = 'red']";
    
    private static final String NO_PERMISSION_USERNAME = "majors";
    private static final String VIEWER_PERMISSION_USERNAME = "jtester";
    
    private static final String ERROR_NOT_AUTHORIZED_OPEN = "not authorized to open document";
    private static final String ERROR_NOT_AUTHORIZED_VIEW = "not authorized to view document";
    private static final String ERROR_NOT_AUTHORIZED_INITIATE = "not authorized to initiate document";
    
    private static final String SAVE_BUTTON = "methodToCall.save";
    
    private CommitteeSeleniumHelper helper;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        
        helper = CommitteeSeleniumHelper.instance(driver);
        helper.loginBackdoor();
    }
    
    @After
    public void tearDown() throws Exception {
        helper.loginBackdoor();
        helper = null;
        
        super.tearDown();
    }
    
    /**
     * Tests that user who doesn't have read-only access to a committee will not be able to view it.
     * 
     * @throws Exception
     */
    @Test
    public void testBlankAuthorization() throws Exception {
        helper.createCommittee();
        
        String documentNumber = helper.getDocumentNumber();
        helper.closeDocument();
        helper.loginBackdoor(NO_PERMISSION_USERNAME);
        helper.docSearch(documentNumber);
        
        helper.assertSelectorContains(ERROR_ID, ERROR_NOT_AUTHORIZED_OPEN);
    }
    
    /**
     * Tests that a user who has read-only access to a committee can view it but not modify it.
     * 
     * @throws Exception
     */
    @Test
    public void testViewAuthorization() throws Exception {
        helper.createCommittee();
        
        String documentNumber = helper.getDocumentNumber();
        helper.closeDocument();
        helper.loginBackdoor(VIEWER_PERMISSION_USERNAME);
        helper.docSearch(documentNumber);
        
        helper.assertSelectorDoesNotContain(ERROR_ID, ERROR_NOT_AUTHORIZED_VIEW);
        
        helper.assertElementDoesNotExist(SAVE_BUTTON);
    }
    
    /**
     * Tests that the who has full access to a committee can view and modify a committee.
     */
    @Test
    public void testCreateAuthorizationNoError() throws Exception {
        helper.createCommittee();
    }
    
    /**
     * Tests that a user who doesn't have create access to a committee will not be able to create it.
     * 
     * @throws Exception
     */
    @Test
    public void testCreateAuthorizationError() throws Exception {
        helper.loginBackdoor(NO_PERMISSION_USERNAME);
        
        helper.clickCentralAdminTab();
        
        helper.click(CREATE_COMMITTEE_LINK_NAME);
        
        helper.assertSelectorContains(ERROR_ID, ERROR_NOT_AUTHORIZED_INITIATE);
    }
    
    /**
     * Tests that a user who full access to a committee can both create and modify it.
     */
    @Test
    public void testModifyAuthorization() throws Exception {
        helper.createCommittee();
        
        helper.assertNoPageErrors();
        
        helper.saveDocument();
        
        helper.assertNoPageErrors();
    }

}