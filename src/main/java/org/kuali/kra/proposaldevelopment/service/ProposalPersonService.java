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
package org.kuali.kra.proposaldevelopment.service;

import java.util.List;

import org.kuali.kra.bo.KcPerson;
import org.kuali.kra.proposaldevelopment.bo.ProposalPerson;
import org.kuali.kra.proposaldevelopment.document.ProposalDevelopmentDocument;

public interface ProposalPersonService {
    public String getPersonName(ProposalDevelopmentDocument doc, String userId);

    public KcPerson getPerson(String loggedInUser);

    /**
     * Retrieve a persisted <code>{@link ProposalPerson}</code> instance using the <code>proposalNumber</code>
     * and <code>proposalPersonNumber</code> 
     * 
     * @param proposalNumber
     * @param proposalPersonNumber
     */
    public ProposalPerson getProposalPersonById(String proposalNumber, Integer proposalPersonNumber);
    
    public List<ProposalPerson> getProposalKeyPersonnel(String proposalNumber);
    
    public List<ProposalPerson> getProposalKeyPersonnel(String proposalNumber, String roleName);
    
    /**
     * This method is to get division name using the 4th level node on the Unit hierarchy
     * 
     * @param proposalPerson Proposal person.
     * @return divisionName based on the 4th level node on the Unit hierarchy.
     */
    public String getProposalPersonDivisionName(ProposalPerson proposalPerson);
    
    /**
     * 
     * This method will be used by person.tag to rebuild the state select list after a country has been changed.
     * @param countryCode
     * @return
     */
    public String getNewStateList(String countryCode);
}
