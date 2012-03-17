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
package org.kuali.kra.coi.personfinancialentity;

import java.util.LinkedHashMap;
import java.util.List;

import org.kuali.kra.bo.KraPersistableBusinessObjectBase;

/**
 * 
 * This class is FE data matrix.
 */
public class FinEntitiesDataMatrix extends KraPersistableBusinessObjectBase { 

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -7588988427003150929L;
    private String columnName; 
    private String columnLabel; 
    private String guiType; 
    private String lookupArgument; 
    private Integer dataGroupId; 
    private boolean statusFlag; 
    private Integer columnSortId; 
    
    private FinEntitiesDataGroup finEntitiesDataGroup; 
    private List<PersonFinIntDisclDet> perFinIntDisclDets; 
    
    public FinEntitiesDataMatrix() { 

    } 
    
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnLabel() {
        return columnLabel;
    }

    public void setColumnLabel(String columnLabel) {
        this.columnLabel = columnLabel;
    }

    public String getGuiType() {
        return guiType;
    }

    public void setGuiType(String guiType) {
        this.guiType = guiType;
    }

    public String getLookupArgument() {
        return lookupArgument;
    }

    public void setLookupArgument(String lookupArgument) {
        this.lookupArgument = lookupArgument;
    }

    public Integer getDataGroupId() {
        return dataGroupId;
    }

    public void setDataGroupId(Integer dataGroupId) {
        this.dataGroupId = dataGroupId;
    }

    public boolean getStatusFlag() {
        return statusFlag;
    }

    public void setStatusFlag(boolean statusFlag) {
        this.statusFlag = statusFlag;
    }

    public Integer getColumnSortId() {
        return columnSortId;
    }

    public void setColumnSortId(Integer columnSortId) {
        this.columnSortId = columnSortId;
    }

    public FinEntitiesDataGroup getFinEntitiesDataGroup() {
        return finEntitiesDataGroup;
    }

    public void setFinEntitiesDataGroup(FinEntitiesDataGroup finEntitiesDataGroup) {
        this.finEntitiesDataGroup = finEntitiesDataGroup;
    }

    /** {@inheritDoc} */
    @Override 
    protected LinkedHashMap<String, Object> toStringMapper() {
        LinkedHashMap<String, Object> hashMap = new LinkedHashMap<String, Object>();
        hashMap.put("columnName", this.getColumnName());
        hashMap.put("columnLabel", this.getColumnLabel());
        hashMap.put("guiType", this.getGuiType());
        hashMap.put("lookupArgument", this.getLookupArgument());
        hashMap.put("dataGroupId", this.getDataGroupId());
        hashMap.put("statusFlag", this.getStatusFlag());
        hashMap.put("columnSortId", this.getColumnSortId());
        return hashMap;
    }

    public List<PersonFinIntDisclDet> getPerFinIntDisclDets() {
        return perFinIntDisclDets;
    }

    public void setPerFinIntDisclDets(List<PersonFinIntDisclDet> perFinIntDisclDets) {
        this.perFinIntDisclDets = perFinIntDisclDets;
    }
    
}