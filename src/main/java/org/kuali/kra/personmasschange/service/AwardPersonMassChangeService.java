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
package org.kuali.kra.personmasschange.service;

import java.util.List;

import org.kuali.kra.award.home.Award;
import org.kuali.kra.personmasschange.bo.PersonMassChange;

/**
 * Defines the service interface for performing a Person Mass Change on Awards.
 */
public interface AwardPersonMassChangeService {
    
    /**
     * Returns the Awards that would have a Person Mass Change performed on them.
     * 
     * @param personMassChange the Person Mass Change to be performed
     * @return the Awards that would have a Person Mass Change performed on them
     */
    List<Award> getAwardChangeCandidates(PersonMassChange personMassChange);
    
    /**
     * Performs the Person Mass Change on the Awards.
     * 
     * @param personMassChange the Person Mass Change to be performed
     * @param awardChangeCandidates the Awards to perform a Person Mass Change on
     */
    void performPersonMassChange(PersonMassChange personMassChange, List<Award> awardChangeCandidates);

}