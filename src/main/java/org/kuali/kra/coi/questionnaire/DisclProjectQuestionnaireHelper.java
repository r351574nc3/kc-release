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
package org.kuali.kra.coi.questionnaire;

import org.kuali.kra.coi.CoiDisclProject;
import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.kra.coi.CoiDisclosureForm;
import org.kuali.kra.questionnaire.answer.ModuleQuestionnaireBean;

public class DisclProjectQuestionnaireHelper extends DisclosureQuestionnaireHelper {

    private String originalDisclosureId;
    private CoiDisclProject coiDisclProject;
    
    public DisclProjectQuestionnaireHelper(CoiDisclProject coiDisclProject, CoiDisclosure coiDisclosure, String originalDisclosureId) {
        super(coiDisclosure);
        this.coiDisclProject = coiDisclProject;
        this.originalDisclosureId = originalDisclosureId;  
    }

    @Override
    public ModuleQuestionnaireBean getModuleQnBean() {
        return new DisclosureModuleQuestionnaireBean(originalDisclosureId, getCoiDisclProject(), 
                getCoiDisclosure().getCoiDisclosureDocument().getDocumentHeader().hasWorkflowDocument() ? getCoiDisclosure().getCoiDisclosureDocument().getDocumentHeader().getWorkflowDocument().isApproved() : false);
    }

    public CoiDisclProject getCoiDisclProject() {
        return coiDisclProject;
    }

    public void setCoiDisclProject(CoiDisclProject coiDisclProject) {
        this.coiDisclProject = coiDisclProject;
        setCoiDisclosure(coiDisclProject.getCoiDisclosure());
    }

    public String getOriginalDisclosureId() {
        return originalDisclosureId;
    }

    public void setOriginalDisclosureId(String originalDisclosureId) {
        this.originalDisclosureId = originalDisclosureId;
    }
    
    public void preSave(CoiDisclosure coiDisclosure) {
        setCoiDisclosure(coiDisclosure);
        super.preSave();
    }    

}
