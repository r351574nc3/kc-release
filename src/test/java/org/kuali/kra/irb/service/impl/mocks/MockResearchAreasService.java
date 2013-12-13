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
package org.kuali.kra.irb.service.impl.mocks;

import java.util.ArrayList;
import java.util.List;

import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.committee.bo.CommitteeMembership;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.ResearchArea;
import org.kuali.kra.irb.service.ResearchAreasService;
import org.kuali.kra.service.ResearchAreaCurrentReferencerHolderBase;

public class MockResearchAreasService implements ResearchAreasService {
    
    private List<ResearchArea> researchAreas = new ArrayList<ResearchArea>();

    public String getAscendantList(String researchAreaCode) {
        // TODO Auto-generated method stub
        return null;
    }

    public String getInitialResearchAreasList() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getSubResearchAreasForTreeView(String researchAreaCode, boolean activeOnly) {
        // TODO Auto-generated method stub
        return null;
    }

    public void addResearchAreas(String researchAreaCode, String parentResearchAreaCode, boolean hasChildrenFlag) {
        ResearchArea researchArea = new ResearchArea();
        researchArea.setResearchAreaCode(researchAreaCode);
        researchArea.setParentResearchAreaCode(parentResearchAreaCode);
        researchArea.setHasChildrenFlag(hasChildrenFlag);
        researchArea.setDescription("research area "+researchAreaCode);
        researchAreas.add(researchArea);
    }
    public boolean isResearchAreaExist(String researchAreaCode, String researchAreas) {
        // TODO Auto-generated method stub
        return false;
    }

    public void saveResearchAreas(String sqlScripts) {
        // TODO Auto-generated method stub
        
    }

    public boolean checkResearchAreaAndDescendantsNotReferenced(String researchAreaCode) {
        // TODO Auto-generated method stub
        return false;
    }

    public void deleteResearchArea(String researchAreaCode) throws Exception {
        // TODO Auto-generated method stub
        
    }

    public ResearchAreaCurrentReferencerHolderBase getAnyCurrentReferencerForResearchAreaOrDescendant(String researchAreaCode) {
        // TODO Auto-generated method stub
        return null;
    }

    public Protocol getCurrentProtocolReferencingResearchArea(String researchAreaCode) {
        // TODO Auto-generated method stub
        return null;
    }

    public Committee getCurrentCommitteeReferencingResearchArea(String researchAreaCode) {
        // TODO Auto-generated method stub
        return null;
    }

    public CommitteeMembership getCurrentCommitteeMembershipReferencingResearchArea(String researchAreaCode) {
        // TODO Auto-generated method stub
        return null;
    }

    public void deactivateResearchAreaAndDescendants(String researchAreaCode) throws Exception {
        // TODO Auto-generated method stub
        
    }

    public void deleteResearchAreaAndDescendants(String researchAreaCode) throws Exception {
        // TODO Auto-generated method stub
        
    }

}
