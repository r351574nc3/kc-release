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
package org.kuali.kra.iacuc.actions.decision;

import org.kuali.kra.iacuc.actions.submit.IacucProtocolReviewType;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.protocol.actions.decision.CommitteeDecisionRule;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmission;

public class IacucCommitteeDecisionRule extends CommitteeDecisionRule<IacucCommitteeDecision> {

    @Override
    protected String getNoCommentsForRevisionsErrorMessageHook() {
        return KeyConstants.ERROR_PROTOCOL_RECORD_COMMITEE_NO_MINOR_MAJOR_DISAPPROVE_REVIEWER_COMMENTS;
    }
    

    @Override
    protected boolean processCounts(ProtocolSubmission submission, IacucCommitteeDecision committeeDecision) {
        boolean retVal = true;
        if(!submission.getProtocolReviewTypeCode().equals(IacucProtocolReviewType.DESIGNATED_MEMBER_REVIEW)) {
            retVal = super.processCounts(submission, committeeDecision);
        }
        return retVal;
    }
    
}
