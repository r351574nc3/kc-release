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
package org.kuali.kra.award.contacts;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * This class runs just the unit tests
 */
@Ignore("Not running because it would result in duplicate tests being executed")
@RunWith(value=Suite.class)
@SuiteClasses(value={AwardPersonTest.class, 
                     AwardProjectPersonAddRuleImplTest.class, 
                     AwardProjectPersonsSaveRuleImplTest.class,
                     ContactCategoryConversionTest.class})
public class UnitTestSuite {

}
