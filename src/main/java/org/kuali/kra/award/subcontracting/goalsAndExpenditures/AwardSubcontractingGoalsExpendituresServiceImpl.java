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
package org.kuali.kra.award.subcontracting.goalsAndExpenditures;

import java.util.HashMap;
import java.util.Map;

import org.kuali.kra.award.subcontracting.reporting.SubcontractingExpenditureCategoryAmounts;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.KRADServiceLocator;

public class AwardSubcontractingGoalsExpendituresServiceImpl implements AwardSubcontractingGoalsExpendituresService {

    private static final String AWARD_NUMBER = "awardNumber";
    private BusinessObjectService businessObjectService;

    @Override
    public AwardSubcontractingBudgetedGoals getBudgetedGoalsBOForAward(String awardNumber) {
        AwardSubcontractingBudgetedGoals retVal;            
        // check if the goals-expense BO for this award number was previously stored, or else create a fresh one.
        Map<String, String> fieldValues = new HashMap<String, String>();
        fieldValues.put(AWARD_NUMBER, awardNumber);
        retVal = getBusinessObjectService().findByPrimaryKey(AwardSubcontractingBudgetedGoals.class, fieldValues);            
        if (retVal == null) {
            retVal = new AwardSubcontractingBudgetedGoals(awardNumber);
        }
        return retVal;
    }

    @Override
    public void saveBudgetedGoalsBO(AwardSubcontractingBudgetedGoals budgetedGoalsBO) {
        // use the boService to save the BO
        getBusinessObjectService().save(budgetedGoalsBO);
        // reset the fresh flag on the BO, since its now in the data store
        budgetedGoalsBO.setFresh(false); 
    }
    
    @Override
    public SubcontractingExpenditureCategoryAmounts getExpenditureAmountsBOForAward(String awardNumber) {
        SubcontractingExpenditureCategoryAmounts retVal;            
        // check if the expense BO for this award number was previously stored, or else create a fresh one.
        Map<String, String> fieldValues = new HashMap<String, String>();
        fieldValues.put(AWARD_NUMBER, awardNumber);
        retVal = getBusinessObjectService().findByPrimaryKey(SubcontractingExpenditureCategoryAmounts.class, fieldValues);            
        if (retVal == null) {
            retVal = new SubcontractingExpenditureCategoryAmounts(awardNumber);
        }
        return retVal;
    }

    // dependency injection
    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }

    public BusinessObjectService getBusinessObjectService() {
        if (this.businessObjectService == null) {
            this.businessObjectService = KRADServiceLocator.getBusinessObjectService();
        }
        return this.businessObjectService;
    }

}
