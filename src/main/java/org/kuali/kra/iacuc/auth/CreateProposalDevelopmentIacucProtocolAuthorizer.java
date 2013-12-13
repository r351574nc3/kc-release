/*
 * Copyright 2005-2010 The Kuali Foundation
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
package org.kuali.kra.iacuc.auth;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.kuali.kra.authorization.ApplicationTask;
import org.kuali.kra.infrastructure.KraServiceLocator;
import org.kuali.kra.infrastructure.TaskName;
import org.kuali.kra.service.TaskAuthorizationService;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.kra.protocol.Protocol;
import org.kuali.kra.protocol.protocol.funding.ProtocolFundingSource;
/**
 * This service class is used to do authorization for create proposal task for proposal development document.  
 */
public class CreateProposalDevelopmentIacucProtocolAuthorizer extends IacucProtocolAuthorizer {

    /**
     * {@inheritDoc}
     * @see org.kuali.kra.protocol.auth.ProtocolAuthorizer#isAuthorized(java.lang.String, org.kuali.kra.protocol.auth.ProtocolTask)
     */
    public boolean isAuthorized(String userId, IacucProtocolTask task) {

        Protocol protocol = (Protocol)task.getProtocol();

        return ( canCreateProposal() && hasProposalRequiredFields(protocol)); 
    }

    private boolean canCreateProposal()
    {
        ApplicationTask task = new ApplicationTask(TaskName.CREATE_PROPOSAL);       
        TaskAuthorizationService taskAuthenticationService = KraServiceLocator.getService(TaskAuthorizationService.class);
        boolean canCreateProposal = taskAuthenticationService.isAuthorized(GlobalVariables.getUserSession().getPrincipalId(), task);
        return canCreateProposal;
    }
        
    private boolean hasProposalRequiredFields(Protocol protocol)
    {
        boolean validProposalRequiredFields=true;
             
        if (StringUtils.isEmpty(protocol.getTitle()))
        {
            validProposalRequiredFields = false;
        }
        if (StringUtils.isEmpty(protocol.getLeadUnitNumber()))
        {
            validProposalRequiredFields = false;
        }
        if (StringUtils.isEmpty(protocol.getPrincipalInvestigatorId()))
        {
            validProposalRequiredFields = false;
        }
        // find sponsor from funding source
        List<ProtocolFundingSource> protocolFundingSources = protocol.getProtocolFundingSources();
        ProtocolFundingSource sponsorProtocolFundingSource = null; 
        for(ProtocolFundingSource protocolFundingSource : protocolFundingSources)
        {
            if ( protocolFundingSource.isSponsorFunding() )
            {
                sponsorProtocolFundingSource = protocolFundingSource;
                break;
            }
        }
        if(sponsorProtocolFundingSource == null)
        {
            validProposalRequiredFields = false;
        }
        
        return validProposalRequiredFields;
    }
    
}
