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
package org.kuali.kra.rules;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.budget.core.CostElement;
import org.kuali.kra.maintenance.MaintenanceRuleTestBase;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.util.GlobalVariables;

public class KraMaintenanceDocumentRuleBaseTest extends MaintenanceRuleTestBase {
    private KraMaintenanceDocumentRuleBase rule = null;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        rule = new KraMaintenanceDocumentRuleBase();
        GlobalVariables.setUserSession(new UserSession("quickstart"));
    }

    @After
    public void tearDown() throws Exception {
        rule = null;
        super.tearDown();
    }

    @Test
    public void testOK() throws Exception {

        
        Map pkMap = new HashMap();
        pkMap.put("costElement", "422311");
        assertTrue(rule.checkExistenceFromTable(CostElement.class, pkMap, "costElement", "Cost Element"));
    }

    /**
     * 
     * This method to test rate type does not exist.
     * @throws Exception
     */
    @Test
    public void testNotExist() throws Exception {

        Map pkMap = new HashMap();
        pkMap.put("costElement", "1x");
        assertFalse(rule.checkExistenceFromTable(CostElement.class, pkMap, "costElement", "Cost Element"));

    }


}
