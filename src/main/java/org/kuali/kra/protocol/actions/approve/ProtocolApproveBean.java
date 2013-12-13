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
package org.kuali.kra.protocol.actions.approve;

import java.sql.Date;

import org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionBean;

/**
 * This class is really just a "form" for approving a protocol.
 */
public interface ProtocolApproveBean extends ProtocolGenericActionBean {
   
    public Date getApprovalDate();
    
    public void setApprovalDate(Date approvalDate);
    
    public Date getExpirationDate();
    
    public void setExpirationDate(Date expirationDate);
    
}
