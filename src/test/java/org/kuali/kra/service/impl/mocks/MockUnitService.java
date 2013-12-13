/*
 * Copyright 2005-2013 The Kuali Foundation
 * 
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.osedu.org/licenses/ECL-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.kra.service.impl.mocks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.kuali.kra.bo.Unit;
import org.kuali.kra.bo.UnitAdministrator;
import org.kuali.kra.bo.UnitCorrespondent;
import org.kuali.kra.infrastructure.KraServiceLocator;
import org.kuali.kra.service.UnitService;

/**
 * The Mock Unit Service.  A set of "fake" units can be added
 * to the Mock Unit Service in order to create a unit hierarchy.
 * This is done via the addUnit() method.  Once configured, the
 * service can be queried.
 */
public class MockUnitService implements UnitService {
    
    private List<Unit> units = new ArrayList<Unit>();

    /**
     * Add a mock unit to the unit service.
     * @param unitNumber
     * @param parentUnitNumber
     */
    public void addUnit(String unitNumber, String parentUnitNumber) {
        Unit unit = new Unit();
        unit.setUnitNumber(unitNumber);
        unit.setUnitName("Name_" + unitNumber);
        unit.setParentUnitNumber(parentUnitNumber);
        if (parentUnitNumber == null) {
            unit.setParentUnit(null);
        } else {
            unit.setParentUnit(getUnit(parentUnitNumber));
        }
        units.add(unit);
    }
    
    /**
     * @see org.kuali.kra.service.UnitService#getAllSubUnits(java.lang.String)
     */
    public List<Unit> getAllSubUnits(String unitNumber) {
        List<Unit> units = new ArrayList<Unit>();
        List<Unit> subUnits = getSubUnits(unitNumber);
        units.addAll(subUnits);
        for (Unit subUnit : subUnits) {
            units.addAll(getAllSubUnits(subUnit.getUnitNumber()));
        }
        return units;
    }
    
    /**
     * 
     * @see org.kuali.kra.service.UnitService#getUnitHierarchyForUnit(java.lang.String)
     */
    public List<Unit> getUnitHierarchyForUnit(String unitNumber) {
        List<Unit> units = new ArrayList<Unit>();
        Unit thisUnit = this.getUnit(unitNumber);
        if (thisUnit != null) {
            units.addAll(getUnitParentsAndSelf(thisUnit));
        }
        return units;
    }
    
    private List<Unit> getUnitParentsAndSelf(Unit unit) {
        List<Unit> units = new ArrayList<Unit>();
        if (!StringUtils.isEmpty(unit.getParentUnitNumber())) {
            units.addAll(getUnitHierarchyForUnit(unit.getParentUnitNumber()));
        }
        units.add(unit);
        return units;
    }

    /**
     * @see org.kuali.kra.service.UnitService#getSubUnits(java.lang.String)
     */
    public List<Unit> getSubUnits(String unitNumber) {
        List<Unit> subUnits = new ArrayList<Unit>();
        for (Unit unit : units) {
            if (StringUtils.equals(unitNumber, unit.getParentUnitNumber())) {
                subUnits.add(unit);
            }
        }
        return subUnits;
    }
    
    
    /**
     * @see org.kuali.kra.service.UnitService#getUnitCaseInsensitive(java.lang.String)
     */
    public Unit getUnitCaseInsensitive(String unitNumber) {
        for (Unit unit : units) {
            if (StringUtils.equals(unitNumber.toUpperCase(), unit.getUnitNumber().toUpperCase())) {
                return unit;
            }
        }
        return null;
    }

    /**
     * @see org.kuali.kra.service.UnitService#getUnit(java.lang.String)
     */
    public Unit getUnit(String unitNumber) {
        for (Unit unit : units) {
            if (StringUtils.equals(unitNumber, unit.getUnitNumber())) {
                return unit;
            }
        }
        return null;
    }

    /**
     * @see org.kuali.kra.service.UnitService#getUnitName(java.lang.String)
     */
    public String getUnitName(String unitNumber) {
        String name = null;
        Unit unit = getUnit(unitNumber);
        if (unit != null) {
            name = unit.getUnitName();
        }
        return name;
    }

    /**
     * @see org.kuali.kra.service.UnitService#getUnits()
     */
    public Collection<Unit> getUnits() {
        return units;
    }

    public String getSubUnitsForTreeView(String unitNumber) {
        // TODO Auto-generated method stub
        return null;
    }
    
    

    public String getInitialUnitsForUnitHierarchy() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public String getInitialUnitsForUnitHierarchy(int depth) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<UnitAdministrator> retrieveUnitAdministratorsByUnitNumber(String unitNumber) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public List<UnitCorrespondent> retrieveUnitCorrespondentsByUnitNumber(String unitNumber) {
        // TODO Auto-generated method stub
        return null;
    }

    public int getMaxUnitTreeDepth() {
        return 10;
    }

    public Unit getTopUnit() {
        // TODO Auto-generated method stub
        return null;
    }

 
}
