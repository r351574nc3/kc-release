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
package org.kuali.kra.common.committee.bo.businessLogic.impl;

import org.kuali.kra.common.committee.bo.CommonCommittee;
import org.kuali.kra.common.committee.bo.CommitteeResearchArea;
import org.kuali.kra.common.committee.bo.businessLogic.CommonCommitteeBusinessLogic;
import org.kuali.kra.common.committee.bo.businessLogic.CommonCommitteeCollaboratorBusinessLogicFactory;
import org.kuali.kra.common.committee.bo.businessLogic.CommonCommitteeCollaboratorBusinessLogicFactoryGroup;
import org.kuali.kra.common.committee.bo.businessLogic.CommonCommitteeResearchAreaBusinessLogic;

public class CommitteeCollaboratorBusinessLogicFactoryGroupImpl implements CommonCommitteeCollaboratorBusinessLogicFactoryGroup {
    
    private CommonCommitteeCollaboratorBusinessLogicFactory<CommonCommittee, CommonCommitteeBusinessLogic> committeeBusinessLogicFactory;
    private CommonCommitteeCollaboratorBusinessLogicFactory<CommitteeResearchArea, CommonCommitteeResearchAreaBusinessLogic> committeeResearchAreaBusinessLogicFactory;
    
    
    public void setCommitteeBusinessLogicFactory(CommonCommitteeCollaboratorBusinessLogicFactory<CommonCommittee, CommonCommitteeBusinessLogic> committeeBusinessLogicFactory) {
        this.committeeBusinessLogicFactory = committeeBusinessLogicFactory;
        // set back pointer to this group into the factory
        this.committeeBusinessLogicFactory.setCommitteeCollaboratorBusinessLogicFactoryGroup(this);
    }
    
    public void setCommitteeResearchAreaBusinessLogicFactory(CommonCommitteeCollaboratorBusinessLogicFactory<CommitteeResearchArea, CommonCommitteeResearchAreaBusinessLogic> committeeResearchAreaBusinessLogicFactory) {
        this.committeeResearchAreaBusinessLogicFactory = committeeResearchAreaBusinessLogicFactory;
        // set back pointer to this group into the factory
        this.committeeResearchAreaBusinessLogicFactory.setCommitteeCollaboratorBusinessLogicFactoryGroup(this);
    }
    
    
    
    public CommonCommitteeResearchAreaBusinessLogic getCommitteeReserachAreaBusinessLogic(CommitteeResearchArea businessObject) {
        return this.committeeResearchAreaBusinessLogicFactory.getBusinessLogicFor(businessObject);
    }
    
    public CommonCommitteeBusinessLogic getCommitteeBusinessLogicFor(CommonCommittee businessObject) {
        return this.committeeBusinessLogicFactory.getBusinessLogicFor(businessObject);
    }
    
}
