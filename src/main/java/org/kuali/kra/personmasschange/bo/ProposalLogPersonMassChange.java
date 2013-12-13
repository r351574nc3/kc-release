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
package org.kuali.kra.personmasschange.bo;

import org.kuali.kra.bo.KraPersistableBusinessObjectBase;

/**
 * Defines the fields for a Proposal Log Person Mass Change.
 */
public class ProposalLogPersonMassChange extends KraPersistableBusinessObjectBase {

    private static final long serialVersionUID = 3351381999001017550L;
    
    private long proposalLogPersonMassChangeId;
    private long personMassChangeId;
    private boolean principalInvestigator;
    
    private PersonMassChange personMassChange;

    public long getProposalLogPersonMassChangeId() {
        return proposalLogPersonMassChangeId;
    }

    public void setProposalLogPersonMassChangeId(long proposalLogPersonMassChangeId) {
        this.proposalLogPersonMassChangeId = proposalLogPersonMassChangeId;
    }

    public long getPersonMassChangeId() {
        return personMassChangeId;
    }

    public void setPersonMassChangeId(long personMassChangeId) {
        this.personMassChangeId = personMassChangeId;
    }

    public boolean isPrincipalInvestigator() {
        return principalInvestigator;
    }

    public void setPrincipalInvestigator(boolean principalInvestigator) {
        this.principalInvestigator = principalInvestigator;
    }
    
    public PersonMassChange getPersonMassChange() {
        return personMassChange;
    }

    public void setPersonMassChange(PersonMassChange personMassChange) {
        this.personMassChange = personMassChange;
    }

    /**
     * Determines whether this Person Mass Change is required.
     * 
     * @return true if any of the fields are true, false otherwise
     */
    public boolean requiresChange() {
        return principalInvestigator;
    }

}