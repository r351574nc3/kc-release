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
package org.kuali.kra.iacuc.rules;

import java.util.HashMap;
import java.util.Map;

import org.kuali.kra.bo.PersonTraining;
import org.kuali.kra.iacuc.IacucPersonTraining;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.infrastructure.KraServiceLocator;
import org.kuali.kra.rules.KraMaintenanceDocumentRuleBase;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.util.ObjectUtils;

/**
 * Overrides the custom save and approve methods of the maintenance document processing to check uniqueness constraints.
 */
public class IacucPersonTrainingMaintenanceDocumentRule extends KraMaintenanceDocumentRuleBase {

    private static final String PERSON_TRAINING_FIELD_NAME = "personTrainingId";
    
    private transient BusinessObjectService businessObjectService;

    @Override
    protected boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        return checkIacucPersonTraining(document);
    }

    @Override
    protected boolean processCustomApproveDocumentBusinessRules(MaintenanceDocument document) {
        return checkIacucPersonTraining(document);
    }
    
    @Override
    protected boolean processCustomSaveDocumentBusinessRules(MaintenanceDocument document) {
        return checkIacucPersonTraining(document);
    }

    @Override 
    public boolean isDocumentValidForSave(MaintenanceDocument document) {
        return checkIacucPersonTraining(document);
    }

    /**
     * Validates iacuc person training.
     *
     * @param document the maintenance document to check
     * @return true if all uniqueness constraints succeed, false otherwise
     */
    private boolean checkIacucPersonTraining(MaintenanceDocument document) {
        boolean isValid = true;
        
        IacucPersonTraining newIacucPersonTraining = (IacucPersonTraining) document.getNewMaintainableObject().getDataObject();
        
        isValid &= isPersonTrainingValid(newIacucPersonTraining);
        
        return isValid;
    }

    /**
     * Validates person id and person training match.
     * 
     * @param newIacucPersonTraining the new person training
     * @return 
     */
    @SuppressWarnings("unchecked")
    private boolean isPersonTrainingValid(IacucPersonTraining newIacucPersonTraining) {
        boolean isValid = true;
        
        String iacucTrainingPersonId = newIacucPersonTraining.getPersonId();
        Integer personTrainingId = newIacucPersonTraining.getPersonTrainingId();
        
        if(ObjectUtils.isNotNull(personTrainingId)) {
            Map<String, Integer> fieldValues = new HashMap<String, Integer>();
            fieldValues.put(PERSON_TRAINING_FIELD_NAME, personTrainingId);
            PersonTraining personTraining = getBusinessObjectService().findByPrimaryKey(PersonTraining.class, fieldValues);
            if(ObjectUtils.isNotNull(personTraining)) {
                String trainingPersonId = personTraining.getPersonId();
                if(!trainingPersonId.equals(iacucTrainingPersonId)) {
                    isValid = false;
                    putFieldError(PERSON_TRAINING_FIELD_NAME, KeyConstants.ERROR_IACUC_VALIDATION_MISMATCH_PERSON_TRAINING); 
                }
            }else {
                isValid = false;
                putFieldError(PERSON_TRAINING_FIELD_NAME, KeyConstants.ERROR_IACUC_VALIDATION_INVALID_PERSON_TRAINING); 
            }
        }
        return isValid;
    }
    
    public BusinessObjectService getBusinessObjectService() {
        if (businessObjectService == null) {
            businessObjectService = KraServiceLocator.getService(BusinessObjectService.class);
        }
        return businessObjectService;
    }
    
    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }
    
}