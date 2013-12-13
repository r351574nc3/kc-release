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
package org.kuali.kra.iacuc.procedures.rule;

import java.util.List;

import org.kuali.kra.iacuc.procedures.IacucProtocolStudyGroup;
import org.kuali.kra.iacuc.procedures.IacucProtocolStudyGroupBean;
import org.kuali.kra.iacuc.procedures.IacucProtocolStudyGroupDetailBean;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.rule.BusinessRuleInterface;
import org.kuali.kra.rules.ResearchDocumentRuleBase;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.ObjectUtils;

public class AddProtocolStudyGroupRule extends ResearchDocumentRuleBase implements BusinessRuleInterface<AddProtocolStudyGroupEvent>{

    private static final String PROCEDURE_BEAN_PATH = "iacucProtocolStudyGroupBeans";
    
    @Override
    public boolean processRules(AddProtocolStudyGroupEvent event) {
        return processAddStudyGroupBusinessRules(event);
    }
    
    private boolean processAddStudyGroupBusinessRules(AddProtocolStudyGroupEvent event) {
        boolean rulePassed = true;
        rulePassed &= isStudyGroupValid(event);
        /*
        if(rulePassed) {
            rulePassed &= !isDuplicateStudyGroup(event);
        }
        */
        return rulePassed;
    }
    
    /**
     * This method is to verify whether one or more groups/persons are selected during Add
     * @param event
     * @return
     */
    private boolean isStudyGroupValid(AddProtocolStudyGroupEvent event) {
        boolean studyGroupValid = true;
        IacucProtocolStudyGroupBean selectedIacucProtocolStudyGroupBean = event.getProcedureBean();
        List<String> protocolSpeciesAndGroups =  selectedIacucProtocolStudyGroupBean.getProtocolSpeciesAndGroups(); 
        List<String> protocolPersonsResponsible =  selectedIacucProtocolStudyGroupBean.getProtocolPersonsResponsible(); 
        if(ObjectUtils.isNull(protocolSpeciesAndGroups) || ObjectUtils.isNull(protocolPersonsResponsible)) {
            GlobalVariables.getMessageMap().putError(getErrorPath(event), 
                    KeyConstants.ERROR_IACUC_VALIDATION_STUDY_GROUP_VALID);                
            studyGroupValid = false;
        }
        return studyGroupValid;
    }

    /**
     * This method is to check for duplicate study group in the list
     * @param event
     * @return
     */
    private boolean isDuplicateStudyGroup(AddProtocolStudyGroupEvent event) {
        boolean duplicateStudyGroup = false;
        IacucProtocolStudyGroupBean procedureBean = event.getProcedureBean();
        List<String> protocolSpeciesAndGroups =  procedureBean.getProtocolSpeciesAndGroups(); 
        for(String iacucProtocolSpeciesId : protocolSpeciesAndGroups) {
            Integer newProtocolSpeciesId = Integer.parseInt(iacucProtocolSpeciesId);
            for(IacucProtocolStudyGroupDetailBean detailBean : procedureBean.getIacucProtocolStudyGroupDetailBeans()) {
                for(IacucProtocolStudyGroup studyGroup : detailBean.getIacucProtocolStudyGroups()) {
                    if(studyGroup.getIacucProtocolSpeciesId().equals(newProtocolSpeciesId)) {
                        GlobalVariables.getMessageMap().putError(getErrorPath(event), 
                                KeyConstants.ERROR_IACUC_VALIDATION_DUPLICATE_STUDY_GROUP);                
                        duplicateStudyGroup = true;
                    }
                }
            }
        }
        return duplicateStudyGroup;
    }
    
    private String getErrorPath(AddProtocolStudyGroupEvent event) {
        StringBuffer errorPath = new StringBuffer();
        errorPath.append(PROCEDURE_BEAN_PATH);
        errorPath.append("[");
        errorPath.append(event.getProcedureBeanIndex());
        errorPath.append("]");
        return errorPath.toString();
    }
}
