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
package org.kuali.kra.committee.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.kuali.kra.bo.KcPerson;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.service.impl.KraAuthorizationServiceImpl;
import org.kuali.kra.service.impl.mocks.MockKcPersonService;
import org.kuali.kra.service.impl.mocks.MockUnitAuthorizationService;

/**
 * Test the Committee Authorization Service Impl. Mocks are used to isolate the service from KIM. Well-defined data is placed into
 * Mock KIM services. The Committee Authorization Service methods are then invoked and the responses are checked against the expected
 * results.
 * 
 * NOTE: Rather than use the new JMock features, we have these old mock classes that were
 *       originally designed for testing Proposal Development.  Since the same unit tests
 *       are needed, it is simply easier to re-use these mock classes.
 */
@Ignore
public class CommitteeAuthorizationServiceImplTest {
    
    //private MockKimDatabase database;
    private MockUnitAuthorizationService unitAuthService;
    private KraAuthorizationServiceImpl kraAuthService;
    private MockKcPersonService kraPersonService;

    /**
     * Create the mock services and insert them into the committee auth service.
     * 
     * @see org.kuali.kra.KraTestBase#setUp()
     */
    @Before
    public void setUp() throws Exception {
        //database = buildDatabase();
        kraPersonService = buildKraPersonService();

        unitAuthService = new MockUnitAuthorizationService();

        kraAuthService = new KraAuthorizationServiceImpl();
        kraAuthService.setUnitAuthorizationService(unitAuthService);
        kraAuthService.setKcPersonService(kraPersonService);
    }

    /**
     * Test the getUsernames() service method.
     */
    @Test
    public void testGetUsernames() {
//        Committee committee = createCommittee(1);
//        List<String> usernames = kraAuthService.getUserNames(committee, RoleConstants.IRB_ADMINISTRATOR);
//        assertTrue(usernames.size() == 2);
//        assertTrue(usernames.contains("don"));
//        assertTrue(usernames.contains("gary"));
//
//        committee = createCommittee(101);
//        usernames = kraAuthService.getUserNames(committee, RoleConstants.IRB_ADMINISTRATOR);
//        assertTrue(usernames.size() == 0);
    }

    /**
     * Test the addRole() service method.
     */
    @Test
    @Ignore
    public void testAddRole() {
//        Committee committee = createCommittee(99);
//        kraAuthService.addRole("jordan", RoleConstants.IRB_ADMINISTRATOR, committee);
//        List<String> usernames = kraAuthService.getUserNames(committee, RoleConstants.IRB_ADMINISTRATOR);
//        assertTrue(usernames.size() == 1);
//        assertTrue(usernames.contains("jordan"));
    }

    /**
     * Test the removeRole() service method.
     */
    @Test
    public void testRemoveRole() {
//        testAddRole();
//
//        Committee committee = createCommittee(99);
//        kraAuthService.removeRole("barre", RoleConstants.IRB_ADMINISTRATOR, committee);
//        List<String> usernames = kraAuthService.getUserNames(committee, RoleConstants.IRB_ADMINISTRATOR);
//        assertTrue(usernames.size() == 1);
//
//        committeeAuthService.removeRole("jordan", RoleConstants.IRB_ADMINISTRATOR, committee);
//        usernames = kraAuthService.getUserNames(committee, RoleConstants.IRB_ADMINISTRATOR);
//        assertTrue(usernames.size() == 0);
    }

    /**
     * Test the hasPermission() service method.
     */
    @Test
    public void testHasPermission() {
//        Committee committee = createCommittee(1);
//        assertTrue(kraAuthService.hasPermission("don", committee, "create"));
//        assertFalse(kraAuthService.hasPermission("molly", committee, "create"));
    }

    /**
     * Test the hasRole() service method.
     */
    @Test
    public void testHasRole() {
//        Committee committee = createCommittee(1);
//        assertTrue(kraAuthService.hasRole("don", committee, RoleConstants.IRB_ADMINISTRATOR));
//        assertTrue(kraAuthService.hasRole("molly", committee, RoleConstants.IRB_REVIEWER));
//        assertFalse(kraAuthService.hasRole("don", committee, RoleConstants.IRB_REVIEWER));
    }

    /**
     * Test the getRoles() service method.
     */
    @Test
    public void testGetRoles() {
//        Committee committee = createCommittee(3);
//        List<String> roles = kraAuthService.getRoles("vicki", committee);
//        assertTrue(roles.size() == 2);
//        assertTrue(roles.contains(RoleConstants.IRB_ADMINISTRATOR));
//        assertTrue(roles.contains(RoleConstants.IRB_REVIEWER));
    }

    /**
     * Test the getPersonsInRole() service method.
     */
    @Test
    public void testGetPersonsInRole() {
//        Committee committee = createCommittee(1);
//        List<KcPerson> persons = kraAuthService.getPersonsInRole(committee, RoleConstants.IRB_ADMINISTRATOR);
//        assertEquals(2, persons.size());
//        assertTrue(contains(persons, "don"));
//        assertTrue(contains(persons, "gary"));
    }

    /**
     * Create a committee. For testing purposes, we only need its committee number to be set.
     * 
     * @param nbr
     * @return
     */
    private Committee createCommittee(long id) {
        Committee committee = new Committee();
        committee.setId(id);
        return committee;
    }

//    /**
//     * Build a mock database to be used by the mock KIM service.
//     * 
//     * @return
//     */
//    private MockKimDatabase buildDatabase() {
//        MockKimDatabase database = new MockKimDatabase();
//        addRoles(database);
//        addQualifiedRoles(database);
//        return database;
//    }
//
//    /**
//     * Build a Mock KIM Qualified Role service.
//     * 
//     * @return
//     */
//    private MockKimQualifiedRoleService buildQualifiedRoleService() {
//        MockKimQualifiedRoleService service = new MockKimQualifiedRoleService();
//        service.setDatabase(database);
//        return service;
//    }

//    /**
//     * Build a Mock KIM Person Service.
//     * 
//     * @return
//     */
//    private MockKimPersonService buildPersonService() {
//        MockKimPersonService service = new MockKimPersonService();
//        service.setDatabase(database);
//        return service;
//    }

    /**
     * Can we find the username in this list of persons?
     * 
     * @param persons
     * @param username
     * @return
     */
    private boolean contains(List<KcPerson> persons, String username) {
        for (KcPerson person : persons) {
            if (StringUtils.equals(person.getUserName(), username)) {
                return true;
            }
        }
        return false;
    }

//    /**
//     * Add a set of roles/permissions to the mock database.
//     * 
//     * @param service
//     */
//    private void addRoles(MockKimDatabase service) {
//        List<String> permissions = new ArrayList<String>();
//        permissions.add("read");
//        permissions.add("write");
//        permissions.add("create");
//        permissions.add("delete");
//        service.addRole(RoleConstants.IRB_ADMINISTRATOR, permissions);
//
//        permissions = new ArrayList<String>();
//        permissions.add("read");
//        service.addRole(RoleConstants.IRB_REVIEWER, permissions);
//    }
//
//    /**
//     * Add a set of qualified roles to the mock database.
//     * 
//     * @param service
//     */
//    private void addQualifiedRoles(MockKimDatabase service) {
//        Map<String, String> qualifiedAttributes = new HashMap<String, String>();
//        qualifiedAttributes.put("committee", "1");
//        service.addQualifiedRole("don", RoleConstants.IRB_ADMINISTRATOR, qualifiedAttributes);
//
//        qualifiedAttributes = new HashMap<String, String>();
//        qualifiedAttributes.put("committee", "1");
//        service.addQualifiedRole("molly", RoleConstants.IRB_REVIEWER, qualifiedAttributes);
//
//        qualifiedAttributes = new HashMap<String, String>();
//        qualifiedAttributes.put("committee", "1");
//        service.addQualifiedRole("gary", RoleConstants.IRB_ADMINISTRATOR, qualifiedAttributes);
//
//        qualifiedAttributes = new HashMap<String, String>();
//        qualifiedAttributes.put("committee", "2");
//        service.addQualifiedRole("nancy", RoleConstants.IRB_ADMINISTRATOR, qualifiedAttributes);
//
//        qualifiedAttributes = new HashMap<String, String>();
//        qualifiedAttributes.put("committee", "3");
//        service.addQualifiedRole("vicki", RoleConstants.IRB_REVIEWER, qualifiedAttributes);
//
//        qualifiedAttributes = new HashMap<String, String>();
//        qualifiedAttributes.put("committee", "3");
//        service.addQualifiedRole("vicki", RoleConstants.IRB_ADMINISTRATOR, qualifiedAttributes);
//
//        qualifiedAttributes = new HashMap<String, String>();
//        qualifiedAttributes.put("bogus", "3");
//        service.addQualifiedRole("vicki", RoleConstants.IRB_ADMINISTRATOR, qualifiedAttributes);
//
//        qualifiedAttributes = new HashMap<String, String>();
//        qualifiedAttributes.put("committee", "3");
//        service.addQualifiedRole("mickey", RoleConstants.IRB_REVIEWER, qualifiedAttributes);
//
//        qualifiedAttributes = new HashMap<String, String>();
//        qualifiedAttributes.put("committee", "3");
//        service.addQualifiedRole("mickey", RoleConstants.IRB_ADMINISTRATOR, qualifiedAttributes);
//    }

    /**
     * Build a Mock KRA Person service with a set of persons.
     * 
     * @return
     */
    private MockKcPersonService buildKraPersonService() {
        MockKcPersonService service = new MockKcPersonService();
        service.addPerson("don");
        service.addPerson("gary");
        service.addPerson("nancy");
        service.addPerson("molly");
        service.addPerson("vicki");
        service.addPerson("mickey");
        service.addPerson("jordan");
        return service;
    }
}
