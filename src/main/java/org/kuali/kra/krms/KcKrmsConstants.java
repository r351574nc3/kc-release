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
package org.kuali.kra.krms;

public final class KcKrmsConstants {
    
    public static final String UNIT_NUMBER = "Unit Number";
    
    // Ideally these should be in Rice's KrmsConstants
    public static final String MESSAGE_SEPARATOR = ":";
    public static final String MESSAGE_TYPE_ERROR = "E";
    public static final String MESSAGE_TYPE_WARNING = "W";
    public static final String KC_KRMS_FUNCTION_RESOLVER_SERVICE_NAME="KC KRMS Function Resolver Service Name";
    public static final String KRMS_PROPERTY_TYPE_NM = "Property";
    
    /**
     * private utility class ctor.
     * @throws UnsupportedOperationException if called.
     */
    private KcKrmsConstants() {
        throw new UnsupportedOperationException("do not call me");
    }
    
    public static final class ProposalDevelopment {
        
        public static final String PROPOSAL_DEVELOPMENT_CONTEXT = "KC Proposal Development Context";

        public static final String PROPOSAL_DEVELOPMENT_CONTEXT_ID = "KC-PD-CONTEXT";
        
        public static final String TOTAL_COST = "totalCost";
        
        public static final String TOTAL_DIRECT_COST = "totalDirectCost";
        
        public static final String TOTAL_INDIRECT_COST = "totalIndirectCost";
        
        public static final String COST_SHARE_AMOUNT = "costShareAmount";
        
        public static final String UNDERRECOVERY_AMOUNT = "underrecoveryAmount";
        
        public static final String TOTAL_COST_INITIAL = "totalCostInitial";
        
        public static final String TOTAL_DIRECT_COST_LIMIT = "totalDirectCostLimit";
         
        public static final String CFDA_NUMBER = "cfdaNumber";
        
        public static final String OPPORTUNITY_ID = "opportunityId";
        
        public static final String SPONSOR_CODE = "sponsorCode";

        public static final String SPECIFIED_GG_FORM = "specifiedGGForm";
        
        public static final String ACTIVITY_TYPE = "activityType";
        
        public static final String DEADLINE_DATE = "deadlineDate";
        
        public static final String LEAD_UNIT = "leadUnit";
        
        public static final String PROPOSAL_TYPE = "proposalType";
        
        public static final String ANTICIPATED_AWARD_TYPE = "anticipatedAwardType";
        
        public static final String ALL_PROPOSALS = "allProposals";
        
        public static final String AGENCY_DIVISION_CODE = "agencyDivisionCode";
        
        public static final String AGENCY_PROGRAM_CODE = "agencyProgramCode";
        
        public static final String PROPOSAL_NARRATIVES_COMPLETE = "proposalNarrativesComplete";

        public static final String DEVELOPMENT_PROPOSAL = "DevelopmentProposal";

    }

    public static final class Budget {
        public static final String BUDGET_CONTEXT = "KC Budget Context";
    }    
    public static final class Award {
        public static final String AWARD_CONTEXT_ID = "KC-AWARD-CONTEXT";

        public static final String AWARD = "award";
        
        public static final String AWARD_CONTEXT = "KC Award Context";
        
    }
    
    public static final class IrbProtocol {
        
        public static final String IRB_PROTOCOL_CONTEXT = "KC Protocol Context";
        
        public static final String PROTOCOL_REFERENCE_NUMBER_1 = "protocolRefNum1";
        
        public static final String PROTOCOL_REFERENCE_NUMBER_2 = "protocolRefNum2";
        
        public static final String FDA_APPLICATION_NUMBER = "fdaApplicationNumber";
        
        public static final String ALL_PROTOCOLS = "allProtocols";

        public static final String IRB_PROTOCOL_CONTEXT_ID = "KC-PROTOCOL-CONTEXT";

        public static final String IRB_PROTOCOL = "IrbProtocol";
    }
    
    public static final class IacucProtocol {
        
        public static final String IACUC_PROTOCOL_CONTEXT = "KC IACUC Context";
        
        public static final String IACUC_REFERENCE_NUMBER_1 = "iacucRefNum1";
        
        public static final String IACUC_REFERENCE_NUMBER_2 = "iacucRefNum2";
        
        public static final String IACUC_FDA_APPLICATION_NUMBER = "fdaApplicationNumber";

        public static final String IACUC_PROTOCOL_CONTEXT_ID = "KC-IACUC-CONTEXT";

        public static final String IACUC_PROTOCOL = "IacucProtocol";
    }
    
    public static final class CoiDisclosure {
        
        public static final String COI_DISCLOSURE_CONTEXT = "KC Annual COI Disclosure Context";
        public static final String COI_DISCLOSURE = "CoiDisclosure";
        public static final String COI_DISCLOSURE_CONTEXT_ID = "KC-COIDISCLOSURE-CONTEXT";
        
    }

}
