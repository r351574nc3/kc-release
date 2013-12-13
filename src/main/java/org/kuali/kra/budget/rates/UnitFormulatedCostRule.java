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
package org.kuali.kra.budget.rates;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.kuali.kra.award.home.AwardTemplate;
import org.kuali.kra.award.home.AwardTemplateTerm;
import org.kuali.kra.bo.SponsorTermType;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.infrastructure.KraServiceLocator;
import org.kuali.kra.rules.ErrorReporter;
import org.kuali.kra.rules.KraMaintenanceDocumentRuleBase;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.service.BusinessObjectService;

public class UnitFormulatedCostRule extends KraMaintenanceDocumentRuleBase {

    /**
     * Constructs a SponsorTemplateTermsExistenceRule
     */
    public UnitFormulatedCostRule() {
        super();
    }
    
    /**
     * 
     * @see org.kuali.core.maintenance.rules.MaintenanceDocumentRuleBase#processCustomRouteDocumentBusinessRules(org.kuali.core.document.MaintenanceDocument)
     */
    @Override
    protected boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        return checkForUnitCostExistence(document);
    }
    /**
     * 
     * This method is to check the existence of terms of the Sponsor Template.
     * @param maintenanceDocument
     * @return
     */
    private boolean checkForUnitCostExistence(MaintenanceDocument maintenanceDocument) {
        boolean valid = true;
        UnitFormulatedCost newCost = (UnitFormulatedCost) maintenanceDocument.getNewMaintainableObject().getDataObject();

        BusinessObjectService businessObjectService = KraServiceLocator.getService(BusinessObjectService.class);
        Map<String, Object> values = new HashMap<String, Object>();
        values.put("formulatedTypeCode", newCost.getFormulatedTypeCode());
        values.put("unitNumber", newCost.getUnitNumber());
        Collection<UnitFormulatedCost> costs = businessObjectService.findMatching(UnitFormulatedCost.class, values);
        for (UnitFormulatedCost cost : costs) {
            if (!ObjectUtils.equals(newCost.getUnitFormulatedCostId(), cost.getUnitFormulatedCostId())) {
                ErrorReporter errorReporter = new ErrorReporter();
                errorReporter.reportError("document.newMaintainableObject.formulatedTypeCode",
                        KeyConstants.ERROR_FORUMLATED_COST_DUPLICATE);
                return false;
            }
        }
        return true;
    }
    
}
