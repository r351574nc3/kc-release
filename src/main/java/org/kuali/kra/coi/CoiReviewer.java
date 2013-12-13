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
package org.kuali.kra.coi;

import org.kuali.kra.bo.KraPersistableBusinessObjectBase;

public class CoiReviewer extends KraPersistableBusinessObjectBase {

    private static final long serialVersionUID = 8787122160668915118L;

    private String reviewerCode;

    private String description;
    
    public static final String ASSIGNED_REVIEWER = "RVW";
    public static final String REVIEW_COMMITTEE = "COM";
    public static final String OSP_ADMINISTRATOR = "OSP";
    public static final String PRINCIPAL_INVESTIGATOR = "PI";
    
    public String getReviewerCode() {
        return reviewerCode;
    }

    public void setReviewerCode(String reviewerCode) {
        this.reviewerCode = reviewerCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
