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
package org.kuali.kra.irb.actions.assignagenda;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.actions.ProtocolAction;
import org.kuali.kra.irb.actions.ProtocolActionType;
import org.kuali.kra.irb.actions.assigncmtsched.ProtocolAssignCmtSchedService;
import org.kuali.kra.irb.actions.expeditedapprove.ProtocolExpeditedApproveBean;
import org.kuali.kra.irb.actions.submit.ProtocolSubmission;
import org.kuali.kra.irb.actions.submit.ProtocolSubmissionStatus;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.actions.ProtocolActionBase;
import org.kuali.kra.protocol.actions.assignagenda.ProtocolAssignToAgendaServiceImplBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;
import org.kuali.rice.core.api.util.KeyValue;

/**
 * 
 * This class implements ProtocolAssignToAgendaService.
 */
public class ProtocolAssignToAgendaServiceImpl extends ProtocolAssignToAgendaServiceImplBase implements ProtocolAssignToAgendaService {
    
    private static final long serialVersionUID = 986748376;
    
    private ProtocolAssignCmtSchedService protocolAssignCmtSchedService;
    
    public void setProtocolAssignCmtSchedService(ProtocolAssignCmtSchedService protocolAssignCmtSchedService) {
        this.protocolAssignCmtSchedService = protocolAssignCmtSchedService;        
    }
    
    protected String getProtocolSubmissionStatusSubmittedToCommitteeCodeHook() {
        return ProtocolSubmissionStatus.SUBMITTED_TO_COMMITTEE;
    }

    protected String getProtocolSubmissionStatusPendingCodeHook() {
        return ProtocolSubmissionStatus.PENDING;
    }

    protected ProtocolActionBase getNewProtocolAssignToAgendaActionInstanceHook(ProtocolBase protocol, ProtocolSubmissionBase submission) {
        return new ProtocolAction((Protocol) protocol, (ProtocolSubmission) submission, ProtocolActionType.ASSIGN_TO_AGENDA);
    }

    /** {@inheritDoc} */
    public void assignToAgenda(Protocol protocol, ProtocolExpeditedApproveBean actionBean) throws Exception {

        ProtocolSubmission submission = (ProtocolSubmission) findSubmission(protocol);
        // add a new protocol action
        ProtocolAction protocolAction = new ProtocolAction(protocol, submission, ProtocolActionType.ASSIGN_TO_AGENDA);
        protocolAction.setComments(actionBean.getComments());
        protocolAction.setActionDate(new Timestamp(actionBean.getActionDate().getTime()));
        protocol.getProtocolActions().add(protocolAction);
        getProtocolActionService().updateProtocolStatus(protocolAction, protocol);
        getDocumentService().saveDocument(protocol.getProtocolDocument());    
    }
    
    protected String getProtocolSubmissionStatusInAgendaCodeHook() {
        return ProtocolSubmissionStatus.IN_AGENDA;
    }
    
    protected String getProtocolActionTypeAssignToAgendaCodeHook() {
        return ProtocolActionType.ASSIGN_TO_AGENDA;
    }

    protected ProtocolAction getSubmitToIrbProtocolAction(Protocol protocol) {
        Iterator<ProtocolActionBase> i = protocol.getProtocolActions().iterator();
        ProtocolAction returnAction = null;
        while (i.hasNext()) {
            ProtocolAction pa = (ProtocolAction) i.next();
            if (pa.getProtocolActionType().getProtocolActionTypeCode().equals(ProtocolActionType.SUBMIT_TO_IRB) 
                    && (returnAction == null || returnAction.getSequenceNumber().intValue() < pa.getSequenceNumber().intValue() )) {
                returnAction = pa;
            }else if(pa.getProtocolActionType().getProtocolActionTypeCode().equals(ProtocolActionType.WITHDRAWN)){
                returnAction = null;
            }
        }
        // no proper protocol action found, return null
        return returnAction;
    }

    /** {@inheritDoc} */
    public String getAssignedCommitteeId(ProtocolBase protocol) {
        String committeeID = this.protocolAssignCmtSchedService.getAssignedCommitteeId((Protocol) protocol);
        return committeeID;
    }

    /** {@inheritDoc} */
    public String getAssignedScheduleDate(ProtocolBase protocol) {
        String scheduleId = this.protocolAssignCmtSchedService.getAssignedScheduleId((Protocol) protocol);
        List<KeyValue> keyPair = this.getCommitteeService().getAvailableCommitteeDates(getAssignedCommitteeId(protocol));
        for (KeyValue kp : keyPair) {
            if (kp.getKey().equals(scheduleId)) {
                return kp.getValue();
            }
        }
        return null;
    }
}
