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
package org.kuali.kra.protocol.actions.withdraw;

import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.ProtocolDocumentBase;

/**
 * ProtocolBase Withdraw Service.
 */
public interface ProtocolWithdrawService {

    /**
     * Perform the task of withdrawing a protocol. A new protocol document will be created
     * so that it can be re-submitted into workflow at a later time.
     * @param protocol the protocol
     * @param withdrawBean the required data for performing a withdrawal
     * @return new protocol document 
     * @throws Exception 
     */
    public ProtocolDocumentBase withdraw(ProtocolBase protocol, ProtocolWithdrawBean withdrawBean) throws Exception;

    
    /**
     * Perform the task of administratively withdrawing a protocol. A new protocol document will be created
     * so that it can be re-submitted into workflow at a later time.
     * @param protocol the protocol
     * @param withdrawBean the required data for performing a withdrawal
     * @return new protocol document 
     * @throws Exception 
     */
    public ProtocolDocumentBase administrativelyWithdraw(ProtocolBase protocol, ProtocolAdministrativelyWithdrawBean administrativelyWithdrawBean) throws Exception;
    
    /**
     * Perform the task of administratively marking a protocol as 'incomplete'. A new protocol document will be created
     * so that it can be re-submitted into workflow at a later time.
     * @param protocol the protocol
     * @param withdrawBean the required data for performing a withdrawal
     * @return new protocol document 
     * @throws Exception 
     */
    public ProtocolDocumentBase administrativelyMarkIncomplete(ProtocolBase protocol, ProtocolAdministrativelyIncompleteBean markIncompleteBean) throws Exception;
}
