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
package org.kuali.kra.award.subcontracting.reporting;

import java.sql.Date;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.kuali.kra.award.subcontracting.reporting.dao.SubcontractingExpenditureCategoryDetailsDao;
import org.kuali.rice.core.api.util.type.KualiDecimal;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.KRADServiceLocator;

public class SubcontractingExpenditureCategoryServiceImpl implements SubcontractingExpenditureCategoryService {

    private static final String AWARD_NUMBER = "awardNumber";
    private SubcontractingExpenditureCategoryDetailsDao detailsDao;
    private BusinessObjectService businessObjectService;
    
    
    @Override
    public void populateAllAvailableCategoryExpenses() {
        // get all the category details BOs from the database
        Collection<SubcontractingExpenditureCategoryDetails> detailBOs = getBusinessObjectService().findAll(SubcontractingExpenditureCategoryDetails.class);
        // clear the expenses table, populate new expenses BOs and save them
        deleteAllExistingExpenditureCategoryAmountsBOs();
        populateAndSaveExpenditureCategoryAmountsBOs(detailBOs);        
    }

    
    public void deleteAllExistingExpenditureCategoryAmountsBOs() {
        Map<String, String> fieldValues = new HashMap<String, String>();
        fieldValues.put(AWARD_NUMBER, "*");
        getBusinessObjectService().deleteMatching(SubcontractingExpenditureCategoryAmounts.class, fieldValues);
    }
    
    
    @Override
    public void populateCategoryExpensesInDateRange(Date rangeStartDate, Date rangeEndDate) {
        if((rangeStartDate != null ) && (rangeEndDate != null)) {
            // get the category details BOs only within the given date range
            Collection<SubcontractingExpenditureCategoryDetails> detailBOs = getDetailsDao().findCategoryDetailsByFiscalPeriodRange(rangeStartDate, rangeEndDate);
            // clear the expenses-by-range table, populate new expenses-by-range BOs and save them
            deleteAllExistingExpenditureCategoryAmountsDateRangeBOs();
            populateAndSaveExpenditureCategoryAmountsInRangeBOs(detailBOs, rangeStartDate, rangeEndDate);

        }
        else {
            throw new IllegalArgumentException("Both start and end date of the range have to be non-null");
        }
    }
    
    public void deleteAllExistingExpenditureCategoryAmountsDateRangeBOs() {
        Map<String, String> fieldValues = new HashMap<String, String>();
        fieldValues.put(AWARD_NUMBER, "*");
        getBusinessObjectService().deleteMatching(SubcontractingExpenditureCategoryAmountsInDateRange.class, fieldValues);
    }
    
    
    private void populateAndSaveExpenditureCategoryAmountsInRangeBOs(Collection<SubcontractingExpenditureCategoryDetails> detailsBOs, Date rangeStartDate, Date rangeEndDate) {
        HashMap<String, SubcontractingExpenditureCategoryAmountsInDateRange> awardNumberToAmountsBOAssoc = new HashMap<String, SubcontractingExpenditureCategoryAmountsInDateRange>();
        // iterate through the passed in collection and build up the award to amount BO map
        for(SubcontractingExpenditureCategoryDetails detailsBO: detailsBOs) {
            SubcontractingExpenditureCategoryAmountsInDateRange amountsInDateRangeBO;
            // if the award number exists in the map just get its associated amounts BO, else create a fresh one and put it in the map
            String awardNumber = detailsBO.getAwardNumber();
            if(awardNumberToAmountsBOAssoc.containsKey(awardNumber)) {
                amountsInDateRangeBO = awardNumberToAmountsBOAssoc.get(awardNumber);
            }
            else {
                amountsInDateRangeBO = new SubcontractingExpenditureCategoryAmountsInDateRange(awardNumber, rangeStartDate, rangeEndDate);
                awardNumberToAmountsBOAssoc.put(amountsInDateRangeBO.getAwardNumber(), amountsInDateRangeBO);
            }
            this.incrementCategoryAmountsUsingDetails(amountsInDateRangeBO, detailsBO);
        }
        
        // save all the amount BOs in the map that we just populated
        for(SubcontractingExpenditureCategoryAmountsInDateRange amountsBOToBeSaved: awardNumberToAmountsBOAssoc.values()) {
            getBusinessObjectService().save(amountsBOToBeSaved);
        }
        
    }
    
    
    private void populateAndSaveExpenditureCategoryAmountsBOs(Collection<SubcontractingExpenditureCategoryDetails> detailsBOs) {
        HashMap<String, SubcontractingExpenditureCategoryAmounts> awardNumberToAmountsBOAssoc = new HashMap<String, SubcontractingExpenditureCategoryAmounts>();
        // iterate through the passed in collection and build up the award to amount BO map
        for(SubcontractingExpenditureCategoryDetails detailsBO: detailsBOs) {
            SubcontractingExpenditureCategoryAmounts amountsBO;
            // if the award number exists in the map just get its associated amounts BO, else create a fresh one and put it in the map
            String awardNumber = detailsBO.getAwardNumber();
            if(awardNumberToAmountsBOAssoc.containsKey(awardNumber)) {
                amountsBO = awardNumberToAmountsBOAssoc.get(awardNumber);
            }
            else {
                amountsBO = new SubcontractingExpenditureCategoryAmounts(awardNumber);
                awardNumberToAmountsBOAssoc.put(amountsBO.getAwardNumber(), amountsBO);
            }
            this.incrementCategoryAmountsUsingDetails(amountsBO, detailsBO);
        }
        
        // save all the amount BOs in the map that we just populated
        for(SubcontractingExpenditureCategoryAmounts amountsBOToBeSaved: awardNumberToAmountsBOAssoc.values()) {
            getBusinessObjectService().save(amountsBOToBeSaved);
        }
        
    }
    
    

    private void incrementCategoryAmountsUsingDetails(SubcontractingExpenditureCategoryAmountsBase amountsBO, SubcontractingExpenditureCategoryDetails detailsBO) {
        // check each detail category's expense flag, and if set, add the detail amount to that category's expenditure amount
        KualiDecimal detailAmount = detailsBO.getAmount();
        
        if(detailsBO.isLargeBusiness()) {
            amountsBO.addToLargeBusinessExpenditureAmount(detailAmount);
        }
        if(detailsBO.isSmallBusiness()) {
            amountsBO.addToSmallBusinessExpenditureAmount(detailAmount);
        }
        if(detailsBO.isWomanOwned()) {
            amountsBO.addToWomanOwnedExpenditureAmount(detailAmount);
        }
        if(detailsBO.isEightADisadvantage()) {
            amountsBO.addToEightADisadvantageExpenditureAmount(detailAmount);
        }
        if(detailsBO.isHubZone()) {
            amountsBO.addToHubZoneExpenditureAmount(detailAmount);
        }
        if(detailsBO.isVeteranOwned()) {
            amountsBO.addToVeteranOwnedExpenditureAmount(detailAmount);
        }
        if(detailsBO.isServiceDisabledVeteranOwned()) {
            amountsBO.addToServiceDisabledVeteranOwnedExpenditureAmount(detailAmount);
        }
        if(detailsBO.isHistoricalBlackCollege()) {
            amountsBO.addToHistoricalBlackCollegeExpenditureAmount(detailAmount);
        }
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

    // dependency injection
    public void setDetailsDao(SubcontractingExpenditureCategoryDetailsDao detailsDao) {
        this.detailsDao = detailsDao;
    }

    public SubcontractingExpenditureCategoryDetailsDao getDetailsDao() {
        return detailsDao;
    }

}
