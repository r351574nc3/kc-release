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
package org.kuali.kra.coi.lookup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.rice.krad.bo.BusinessObject;

public class CoiSubmittedDisclosureLookupableHelper extends CoiDisclosureLookupableHelperBase {

    public List<? extends BusinessObject> getSearchResults(Map<String, String> fieldValues) {
        List<CoiDisclosure> allDisclosures = (List<CoiDisclosure>) super.getResults(fieldValues);
        List<CoiDisclosure> submittedDisclosures = new ArrayList<CoiDisclosure>();

        for (CoiDisclosure disclosure : allDisclosures) {
            if (disclosure.isSubmitted()) {
                submittedDisclosures.add(disclosure);
            }
        }
        return submittedDisclosures;
    }
}
