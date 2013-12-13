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
 * Defines the fields for an IACUC Protocol Person Mass Change.
 */
public class IacucProtocolPersonMassChange extends KraPersistableBusinessObjectBase {

    private static final long serialVersionUID = 2640850709328683379L;
    
    private long iacucProtocolPersonMassChangeId;
    private long personMassChangeId;
    private boolean investigator;
    private boolean keyStudyPerson;
    private boolean correspondents;
    private boolean reviewer;
    
    private PersonMassChange personMassChange;

    public long getIacucProtocolPersonMassChangeId() {
        return iacucProtocolPersonMassChangeId;
    }

    public void setIacucProtocolPersonMassChangeId(long iacucProtocolPersonMassChangeId) {
        this.iacucProtocolPersonMassChangeId = iacucProtocolPersonMassChangeId;
    }

    public long getPersonMassChangeId() {
        return personMassChangeId;
    }

    public void setPersonMassChangeId(long personMassChangeId) {
        this.personMassChangeId = personMassChangeId;
    }

    public boolean isInvestigator() {
        return investigator;
    }
    
    public void setInvestigator(boolean investigator) {
        this.investigator = investigator;
    }
    
    public boolean isKeyStudyPerson() {
        return keyStudyPerson;
    }
    
    public void setKeyStudyPerson(boolean keyStudyPerson) {
        this.keyStudyPerson = keyStudyPerson;
    }
    
    public boolean isCorrespondents() {
        return correspondents;
    }
    
    public void setCorrespondents(boolean correspondents) {
        this.correspondents = correspondents;
    }
    
    public PersonMassChange getPersonMassChange() {
        return personMassChange;
    }

    public void setPersonMassChange(PersonMassChange personMassChange) {
        this.personMassChange = personMassChange;
    }

    public boolean isReviewer() {
        return reviewer;
    }
    
    public void setReviewer(boolean reviewer) {
        this.reviewer = reviewer;
    }
    
    /**
     * Determines whether this Person Mass Change is required.
     * 
     * @return true if any of the fields are true, false otherwise
     */
    public boolean requiresChange() {
        return investigator || keyStudyPerson || correspondents || reviewer;
    }

}