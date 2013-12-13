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

import org.kuali.rice.core.api.mo.common.active.MutableInactivatable;


/**
 * This class...
 */
public class CitizenshipType extends KraPersistableBusinessObjectBase implements MutableInactivatable {

    private int citizenshipTypeCode;

    private String description;

    private boolean active;

    /**
     * Constructs a CitizenshipType.java.
     */
    public CitizenshipType() {
        super();
    }

    public int getCitizenshipTypeCode() {
        return citizenshipTypeCode;
    }

    public void setCitizenshipTypeCode(int citizenTypeCode) {
        this.citizenshipTypeCode = citizenTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
