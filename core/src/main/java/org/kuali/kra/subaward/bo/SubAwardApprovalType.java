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
package org.kuali.kra.subaward.bo;

import org.kuali.kra.bo.KraPersistableBusinessObjectBase;
import java.util.LinkedHashMap;
import org.kuali.kra.subaward.bo.TemplateSubAwardTerms;
import org.kuali.kra.subaward.bo.AwardSubAwardTerms;

public class SubAwardApprovalType extends KraPersistableBusinessObjectBase { 
    
    private static final long serialVersionUID = 1L;

    private Integer subAwardApprovalTypeCode; 
    private String description; 
    
    private TemplateSubAwardTerms templateSubAwardTerms; 
    private AwardSubAwardTerms awardSubAwardTerms; 
    
    public SubAwardApprovalType() { 

    } 
    
   

    public Integer getSubAwardApprovalTypeCode() {
        return subAwardApprovalTypeCode;
    }
    
    public void setSubAwardApprovalTypeCode(Integer subAwardApprovalTypeCode) {
        this.subAwardApprovalTypeCode = subAwardApprovalTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TemplateSubAwardTerms getTemplateSubAwardTerms() {
        return templateSubAwardTerms;
    }

    public void setTemplateSubAwardTerms(TemplateSubAwardTerms templateSubAwardTerms) {
        this.templateSubAwardTerms = templateSubAwardTerms;
    }

    public AwardSubAwardTerms getAwardSubAwardTerms() {
        return awardSubAwardTerms;
    }

    public void setAwardSubAwardTerms(AwardSubAwardTerms awardSubAwardTerms) {
        this.awardSubAwardTerms = awardSubAwardTerms;
    }

    /** {@inheritDoc} */
    @Override 
    protected LinkedHashMap<String, Object> toStringMapper() {
        LinkedHashMap<String, Object> hashMap = new LinkedHashMap<String, Object>();
        hashMap.put("subAwardApprovalTypeCode", this.getSubAwardApprovalTypeCode());
        hashMap.put("description", this.getDescription());
        return hashMap;
    }    
}