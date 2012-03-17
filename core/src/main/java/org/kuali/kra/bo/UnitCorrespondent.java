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
package org.kuali.kra.bo;

import org.kuali.kra.bo.KraPersistableBusinessObjectBase;
import org.kuali.kra.irb.correspondence.CorrespondentType;
import java.util.LinkedHashMap;

public class UnitCorrespondent extends KraPersistableBusinessObjectBase { 
    
    private static final long serialVersionUID = 1L;

    private Integer unitCorrespondentId; 
    private String unitNumber; 
    private Integer correspondentTypeCode; 
    private String personId; 
    private boolean nonEmployeeFlag; 
    private String description; 
    
    private Unit unit; 
    private CorrespondentType correspondentType; 
    
    public UnitCorrespondent() { 

    } 
    
    public Integer getUnitCorrespondentId() {
        return unitCorrespondentId;
    }

    public void setUnitCorrespondentId(Integer unitCorrespondentId) {
        this.unitCorrespondentId = unitCorrespondentId;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public Integer getCorrespondentTypeCode() {
        return correspondentTypeCode;
    }

    public void setCorrespondentTypeCode(Integer correspondentTypeCode) {
        this.correspondentTypeCode = correspondentTypeCode;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public boolean getNonEmployeeFlag() {
        return nonEmployeeFlag;
    }

    public void setNonEmployeeFlag(boolean nonEmployeeFlag) {
        this.nonEmployeeFlag = nonEmployeeFlag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public CorrespondentType getCorrespondentType() {
        return correspondentType;
    }

    public void setCorrespondentType(CorrespondentType correspondentType) {
        this.correspondentType = correspondentType;
    }

    /** {@inheritDoc} */
    @Override 
    protected LinkedHashMap<String, Object> toStringMapper() {
        LinkedHashMap<String, Object> hashMap = new LinkedHashMap<String, Object>();
        hashMap.put("unitCorrespondentId", this.getUnitCorrespondentId());
        hashMap.put("unitNumber", this.getUnitNumber());
        hashMap.put("correspondentTypeCode", this.getCorrespondentTypeCode());
        hashMap.put("personId", this.getPersonId());
        hashMap.put("nonEmployeeFlag", this.getNonEmployeeFlag());
        return hashMap;
    }

    public KcPerson getPerson() {
        return getKcPersonService().getKcPersonByPersonId(personId);
    }
}