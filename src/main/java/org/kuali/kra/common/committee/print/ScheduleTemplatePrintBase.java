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
package org.kuali.kra.common.committee.print;

/**
 * 
 * This class identifies the template print functionality for committee schedule reports.
 */
public abstract class ScheduleTemplatePrintBase extends TemplatePrintBase {
    
    
    private static final long serialVersionUID = -1565960151556324475L;
    public static final String REPORT_PARAMETER_KEY = "protoCorrespTypeCode";

    @Override
    public String getProtoCorrespTypeCode() {
        return  (String) getReportParameters().get(REPORT_PARAMETER_KEY);
    }
   
   
}
