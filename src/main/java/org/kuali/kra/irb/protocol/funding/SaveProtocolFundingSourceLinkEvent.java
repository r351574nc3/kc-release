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
package org.kuali.kra.irb.protocol.funding;

import java.util.List;

import org.kuali.rice.krad.document.Document;

/**
 * Represents the event for saving a Protocol Funding Source.
 */
public class SaveProtocolFundingSourceLinkEvent extends org.kuali.kra.protocol.protocol.funding.SaveProtocolFundingSourceLinkEvent {

    public SaveProtocolFundingSourceLinkEvent(Document document, List<ProtocolFundingSource> protocolFundingSources, List<ProtocolFundingSource> deletedProtocolFundingSources) {
        super(document, (List) protocolFundingSources, (List) deletedProtocolFundingSources);
    }
}