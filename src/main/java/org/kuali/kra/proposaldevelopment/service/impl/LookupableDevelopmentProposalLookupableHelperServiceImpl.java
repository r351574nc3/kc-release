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
package org.kuali.kra.proposaldevelopment.service.impl;

import java.util.List;
import java.util.Map;

import org.kuali.kra.proposaldevelopment.bo.LookupableDevelopmentProposal;
import org.kuali.rice.kns.lookup.KualiLookupableHelperServiceImpl;
import org.kuali.rice.krad.bo.BusinessObject;

@SuppressWarnings("deprecation")
public class LookupableDevelopmentProposalLookupableHelperServiceImpl extends KualiLookupableHelperServiceImpl{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -2819167587268360381L;
    
    @SuppressWarnings("unchecked")
    @Override
    public List<? extends BusinessObject> getSearchResults(Map<String, String> fieldValues) {
        List<LookupableDevelopmentProposal> unboundedResults = (List<LookupableDevelopmentProposal>) super.getSearchResultsUnbounded(fieldValues);
        List<LookupableDevelopmentProposal> filteredResults = filterForPermissions(unboundedResults);
        return filteredResults;
    }

    // todo perhaps we may need to filter by user permissions on the proposal, currently does not filter anything, just a placeholder.
    private List<LookupableDevelopmentProposal> filterForPermissions(List<LookupableDevelopmentProposal> unboundedResults) {
        return unboundedResults;
    }  
    

}
