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
package org.kuali.kra.irb.actions.submit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kuali.kra.common.committee.meeting.CommitteeScheduleMinuteBase;
import org.kuali.kra.irb.actions.ProtocolActionType;
import org.kuali.kra.meeting.CommitteeScheduleMinute;
import org.kuali.kra.protocol.actions.ProtocolActionBase;
import org.kuali.kra.protocol.actions.submit.ProtocolActionMappingBase;

/*
 * This class is for the condition attributes of of the protocol action.
 * i.e., the condition of protocol status, submissionstatus, action type code etc.
 */
public class ProtocolActionMapping extends ProtocolActionMappingBase {
    
    private static final Map<String, String> ACTION_TYPE_SUBMISSION_TYPE_MAP;
    static {
        final Map<String, String> codeMap = new HashMap<String, String>();        
        codeMap.put(ProtocolActionType.SUSPENDED, ProtocolSubmissionType.REQUEST_FOR_SUSPENSION);
        codeMap.put(ProtocolActionType.SUSPENDED_BY_DSMB, ProtocolSubmissionType.REQUEST_FOR_SUSPENSION);
        codeMap.put(ProtocolActionType.CLOSED_FOR_ENROLLMENT, ProtocolSubmissionType.REQUEST_TO_CLOSE_ENROLLMENT);
        codeMap.put(ProtocolActionType.DATA_ANALYSIS_ONLY, ProtocolSubmissionType.REQUEST_FOR_DATA_ANALYSIS_ONLY);
        codeMap.put(ProtocolActionType.REOPEN_ENROLLMENT, ProtocolSubmissionType.REQUEST_TO_REOPEN_ENROLLMENT);
        codeMap.put(ProtocolActionType.CLOSED_ADMINISTRATIVELY_CLOSED, ProtocolSubmissionType.REQUEST_TO_CLOSE);
        codeMap.put(ProtocolActionType.TERMINATED, ProtocolSubmissionType.REQUEST_FOR_TERMINATION);        
        ACTION_TYPE_SUBMISSION_TYPE_MAP = Collections.unmodifiableMap(codeMap);
    }

    private static final List<String> APPROVE_ACTION_TYPES;
    static {
        final List<String> codes = new ArrayList<String>();     
        codes.add(ProtocolActionType.APPROVED);
        codes.add(ProtocolActionType.EXPEDITE_APPROVAL);
        codes.add(ProtocolActionType.GRANT_EXEMPTION);
        APPROVE_ACTION_TYPES = codes;
    }
    
    
    public ProtocolActionMapping(String actionTypeCode, String submissionStatusCode, String submissionTypeCode, String protocolReviewTypeCode, String protocolStatusCode, String scheduleId, Integer submissionNumber) {
        super(actionTypeCode, submissionStatusCode, submissionTypeCode, protocolReviewTypeCode, protocolStatusCode, scheduleId, submissionNumber);
    }    
       
    protected Class<? extends CommitteeScheduleMinuteBase> getCommitteeScheduleMinuteBOClassHook() {
        return CommitteeScheduleMinute.class;
    }
    
    
    /**
     * Check if there are any pending submissions for this protocol
     *  whose submission type is not the matching submission type in ACTION_TYPE_SUBMISSION_TYPE_MAP.
     */
    public boolean getSubmissionCount() {
        Map<String, Object> positiveFieldValues = new HashMap<String, Object>();
        positiveFieldValues.put(PROTOCOL_NUMBER, protocol.getProtocolNumber());
        positiveFieldValues.put(SEQUENCE_NUMBER, protocol.getSequenceNumber());
 
        positiveFieldValues.put("submissionStatusCode", getPendingSubmissionStatusCodes());
        
        Map<String, Object> negativeFieldValues = new HashMap<String, Object>();        
        negativeFieldValues.put("submissionTypeCode", ACTION_TYPE_SUBMISSION_TYPE_MAP.get(actionTypeCode));
        
        return businessObjectService.countMatching(ProtocolSubmission.class, positiveFieldValues, negativeFieldValues) == 0;    
    }
    
    /**
     * 
     * This method Checks if there are any pending submissions for this protocol
     * @return
     */
    public boolean getSubmissionCountCond2() {
        Map<String, Object> positiveFieldValues = new HashMap<String, Object>();
        positiveFieldValues.put(PROTOCOL_NUMBER, protocol.getProtocolNumber());
        positiveFieldValues.put(SEQUENCE_NUMBER, protocol.getSequenceNumber());
        positiveFieldValues.put("submissionStatusCode", getPendingSubmissionStatusCodes());
        
        return businessObjectService.countMatching(ProtocolSubmission.class, positiveFieldValues) == 0;
    }
        
    /**
     * 
     * This method check to see if there is pending submission with one of the following submission type
     * 109 --Request to close
     * 110 --Request For Suspension
     * 111 --Request to Close Enrollment
     * 108 --Request for Termination
     * 113 --Request for data analysis
     * 114 --Request for re-open enrollment
     * @return
     */
    public boolean getSubmissionCountCond4() {
        
        Map<String, Object> positiveFieldValues = new HashMap<String, Object>();
        positiveFieldValues.put(PROTOCOL_NUMBER, protocol.getProtocolNumber());
        positiveFieldValues.put(SEQUENCE_NUMBER, protocol.getSequenceNumber());
        positiveFieldValues.put("submissionStatusCode", getPendingSubmissionStatusCodes());
        positiveFieldValues.put("submissionTypeCode", Arrays.asList(new String[] {
                ProtocolSubmissionType.REQUEST_FOR_DATA_ANALYSIS_ONLY, ProtocolSubmissionType.REQUEST_FOR_SUSPENSION,
                ProtocolSubmissionType.REQUEST_FOR_TERMINATION, ProtocolSubmissionType.REQUEST_TO_CLOSE,
                ProtocolSubmissionType.REQUEST_TO_CLOSE_ENROLLMENT, ProtocolSubmissionType.REQUEST_TO_REOPEN_ENROLLMENT}));
        
        return businessObjectService.countMatching(ProtocolSubmission.class, positiveFieldValues) == 0;

    }
        
    /*
     * Coeus called submission status of 100/101/102 as pending submission
     */
    private List<String> getPendingSubmissionStatusCodes() {
        List<String> submissionStatusCodes = new ArrayList<String>();
        submissionStatusCodes.add(ProtocolSubmissionStatus.SUBMITTED_TO_COMMITTEE);
        submissionStatusCodes.add(ProtocolSubmissionStatus.IN_AGENDA); 
        submissionStatusCodes.add(ProtocolSubmissionStatus.PENDING);
        return submissionStatusCodes;

    }
    
    /**
     * check if there are any other pending submissions.
     * Basically, check the matching protocol submission with the highest submission# does not have
     * status of (100,101,102)
     */
    @SuppressWarnings("unchecked")
    public boolean getSubmissionCountCond5() {                
        Map<String, Object> positiveFieldValues = new HashMap<String, Object>();
        positiveFieldValues.put(PROTOCOL_NUMBER, protocol.getProtocolNumber());
        positiveFieldValues.put(SEQUENCE_NUMBER, protocol.getSequenceNumber());
        List<ProtocolSubmission> submissions = (List<ProtocolSubmission>)businessObjectService.findMatchingOrderBy(ProtocolSubmission.class, positiveFieldValues, "submissionNumber", false);
        return submissions.isEmpty() || !getPendingSubmissionStatusCodes().contains(submissions.get(0).getSubmissionStatusCode());
        
    }
    
    /**
     * 
     * This method Check if protocol has a submission which is in statuscode (100,101,102, 201, 202)  
     * @return
     */
    @SuppressWarnings("unchecked")
    public boolean getSubmissionCountForWithdraw() {              
        List <String> statusCodes = Arrays.asList(new String[] {"100","101","102", "201", "202"});
        Map<String, Object> positiveFieldValues = new HashMap<String, Object>();
        positiveFieldValues.put(PROTOCOL_NUMBER, protocol.getProtocolNumber());
        positiveFieldValues.put(SEQUENCE_NUMBER, protocol.getSequenceNumber());
        List<ProtocolSubmission> submissions = (List<ProtocolSubmission>)businessObjectService.findMatchingOrderBy(ProtocolSubmission.class, positiveFieldValues, "submissionNumber", false);
        return !submissions.isEmpty() && statusCodes.contains(submissions.get(0).getSubmissionStatusCode());
        
    }
    
    /**
     * check if this protocol has not been approved
     */
    public boolean isInitialProtocol() {
        boolean initialProtocol = true;
        for (ProtocolActionBase action : protocol.getProtocolActions()) {
            if (APPROVE_ACTION_TYPES.contains(action.getProtocolActionTypeCode())) {
                initialProtocol = false;
                break;
            }
        }
        return initialProtocol;
    }

    /**
     * check if this submission is protocol is just SRR/SMR
     * protocolSubmissions is sorted by submissionNumber in repository.
     */
    public boolean isSubmitForRevision() {
        boolean revisionSubmission = false;
        if (protocol.getProtocolSubmissions().size() >= 2) {
            ProtocolSubmission prevSubmission = (ProtocolSubmission) protocol.getProtocolSubmissions().get(protocol.getProtocolSubmissions().size() - 2);
            if (ProtocolSubmissionStatus.SPECIFIC_MINOR_REVISIONS_REQUIRED.equals(prevSubmission.getSubmissionStatusCode()) || ProtocolSubmissionStatus.SUBSTANTIVE_REVISIONS_REQUIRED
                            .equals(prevSubmission.getSubmissionStatusCode())) {
                revisionSubmission = true;
            }
        }
        return revisionSubmission;
    }

}
