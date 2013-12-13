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
package org.kuali.kra.irb.actions.reviewcomments;

import java.util.ArrayList;
import java.util.List;

import org.kuali.kra.common.committee.meeting.CommitteeScheduleMinuteBase;
import org.kuali.kra.common.committee.meeting.MinuteEntryType;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.RoleConstants;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.irb.actions.submit.ProtocolReviewer;
import org.kuali.kra.irb.actions.submit.ProtocolSubmission;
import org.kuali.kra.irb.actions.submit.ProtocolSubmissionStatus;
import org.kuali.kra.irb.onlinereview.ProtocolOnlineReview;
import org.kuali.kra.irb.onlinereview.ProtocolReviewAttachment;
import org.kuali.kra.meeting.CommitteeScheduleMinute;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.kra.protocol.actions.reviewcomments.ReviewCommentsServiceImplBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewBase;
import org.kuali.kra.protocol.onlinereview.ProtocolReviewableBase;

/**
 * 
 * This class takes care of the persistence for Reviewer comments.
 */
public class ReviewCommentsServiceImpl extends ReviewCommentsServiceImplBase<ProtocolReviewAttachment> implements ReviewCommentsService {

    private static final String[] PROTOCOL_SUBMISSION_COMPLETE_STATUSES = { ProtocolSubmissionStatus.APPROVED, 
                                                                            ProtocolSubmissionStatus.EXEMPT, 
                                                                            ProtocolSubmissionStatus.SPECIFIC_MINOR_REVISIONS_REQUIRED, 
                                                                            ProtocolSubmissionStatus.SUBSTANTIVE_REVISIONS_REQUIRED, 
                                                                            ProtocolSubmissionStatus.DEFERRED,
                                                                            ProtocolSubmissionStatus.WITHDRAWN,
                                                                            ProtocolSubmissionStatus.RETURNED_TO_PI,
                                                                            ProtocolSubmissionStatus.DISAPPROVED };

    @Override
    protected String[] getProtocolSubmissionCompleteStatusCodeArrayHook() {
        return ReviewCommentsServiceImpl.PROTOCOL_SUBMISSION_COMPLETE_STATUSES;
    }

    @Override
    protected Class<? extends CommitteeScheduleMinuteBase> getCommitteeScheduleMinuteBOClassHook() {
        return CommitteeScheduleMinute.class;
    }

    @Override
    protected String getAdministratorRoleHook() {
        return RoleConstants.IRB_ADMINISTRATOR;
    }

    @Override
    protected ProtocolSubmissionBase getSubmission(ProtocolBase protocol) {
        ProtocolSubmissionBase protocolSubmission = protocol.getProtocolSubmission();
        if (protocol.getNotifyIrbSubmissionId() != null) {
            // not the current submission, then check programically
            for (ProtocolSubmissionBase submission : protocol.getProtocolSubmissions()) {
                if (submission.getSubmissionId().equals(protocol.getNotifyIrbSubmissionId())) {
                    protocolSubmission = submission;
                    break;
                }
            }
        }
        return protocolSubmission;
    }

    @Override
    protected String getDisplayRevNameToActiveCmtMembersHook() {
        return Constants.PARAMETER_IRB_DISPLAY_REVIEWER_NAME_TO_ACTIVE_COMMITTEE_MEMBERS;
    }

    @Override
    protected String getDisplayRevNameToProtocolPersonnelHook() {
        return Constants.PARAMETER_IRB_DISPLAY_REVIEWER_NAME_TO_PROTOCOL_PERSONNEL;
    }

    @Override
    protected String getDisplayRevNameToReviewersHook() {
        return Constants.PARAMETER_IRB_DISPLAY_REVIEWER_NAME_TO_REVIEWERS;
    }

    @Override
    protected Class<? extends ProtocolDocumentBase> getProtocolDocumentBOClassHook() {
        return ProtocolDocument.class;
    }

    @Override
    protected Class<? extends org.kuali.kra.protocol.actions.submit.ProtocolReviewer> getProtocolReviewClassHook() {
        return ProtocolReviewer.class;
    }

    @Override
    protected String getNamespaceHook() {
        return Constants.MODULE_NAMESPACE_PROTOCOL;
    }

    @Override
    protected String getAggregatorRoleNameHook() {
        return RoleConstants.PROTOCOL_AGGREGATOR;
    }

    @Override
    protected String getProtocolViewerRoleNameHook() {
        return RoleConstants.PROTOCOL_VIEWER;
    }

    @Override
    protected Class<? extends ProtocolOnlineReviewBase> getProtocolOnlineReviewClassHook() {
        return ProtocolOnlineReview.class;
    }

    @Override
    public void saveReviewAttachments(List<ProtocolReviewAttachment> reviewAttachments,
            List<ProtocolReviewAttachment> deletedReviewAttachments) {
        for (ProtocolReviewAttachment reviewAttachment : reviewAttachments) {
            boolean doUpdate = true;
            if (doUpdate) {
                reviewAttachment.setPrivateFlag(!reviewAttachment.isProtocolPersonCanView());
                businessObjectService.save(reviewAttachment);
            }
        }
        
        if (!deletedReviewAttachments.isEmpty()) {
            businessObjectService.delete(deletedReviewAttachments);
        }
    }

    @Override
    protected Class<ProtocolReviewAttachment> getProtocolReviewAttachmentClassHook() {
        return ProtocolReviewAttachment.class;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public List<CommitteeScheduleMinuteBase> getReviewerComments(String protocolNumber, int submissionNumber) {
        ArrayList<CommitteeScheduleMinuteBase> reviewComments = new ArrayList<CommitteeScheduleMinuteBase>();
        
        List<ProtocolSubmission> protocolSubmissions = (List)getProtocolFinderDao().findProtocolSubmissions(protocolNumber, submissionNumber);
        for (ProtocolSubmission protocolSubmission : protocolSubmissions) {
            if (protocolSubmission.getCommitteeScheduleMinutes() != null) {
                List<CommitteeScheduleMinute> committeeScheduleMinutes = (List)protocolSubmission.getCommitteeScheduleMinutes();
                for (CommitteeScheduleMinute minute : committeeScheduleMinutes) {
                    String minuteEntryTypeCode = minute.getMinuteEntryTypeCode();
                    // need to check current minute entry; otherwise may have minutes from previous version comittee
                    if ((MinuteEntryType.PROTOCOL.equals(minuteEntryTypeCode) || MinuteEntryType.PROTOCOL_REVIEWER_COMMENT.equals(minuteEntryTypeCode)) && isCurrentMinuteEntry(minute)) {
                        minute.setCommitteeIdFromSubmission(protocolSubmission);
                        if(getReviewerCommentsView(minute)){
                            reviewComments.add(minute);
                        }
                    }
                }
            }
        }
        
        return reviewComments;
    }
    
    @SuppressWarnings("rawtypes")
    protected boolean isActiveCommitteeMember(ProtocolReviewableBase minute, String principalId) {
        boolean retVal = false;
        // we have a commitee schedule then let the superclass version handle this
        if(minute.getCommitteeSchedule() != null) {
            retVal = super.isActiveCommitteeMember(minute, principalId);
        }
        // otherwise use the commitee id from submission that should've been set by the caller of this method
        else {
            if(minute instanceof CommitteeScheduleMinute) {
                String committeeId = ((CommitteeScheduleMinute) minute).getCommitteeIdFromSubmission();
                // since there was no committee schedule we set schedule id to be null
                retVal = super.isActiveCommitteeMember(committeeId, null, principalId);
            }
        }
        return retVal;
    }

}