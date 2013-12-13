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
package org.kuali.kra.common.committee.meeting;

import org.kuali.kra.bo.KraPersistableBusinessObjectBase;

/**
 * 
 * This class is standard protocol review comment.
 */
public abstract class ProtocolContingencyBase extends KraPersistableBusinessObjectBase {

    private static final long serialVersionUID = 9043529163603762324L;

    private String protocolContingencyCode;

    private String description;

    public ProtocolContingencyBase() {
    }

    public String getProtocolContingencyCode() {
        return protocolContingencyCode;
    }

    public void setProtocolContingencyCode(String protocolContingencyCode) {
        this.protocolContingencyCode = protocolContingencyCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
