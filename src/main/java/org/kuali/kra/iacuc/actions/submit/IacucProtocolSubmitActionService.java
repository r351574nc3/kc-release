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
package org.kuali.kra.iacuc.actions.submit;

import java.util.List;

import org.kuali.kra.iacuc.IacucProtocol;

/**
 * Handles the processing of submitting a protocol to the IRB office.
 */
public interface IacucProtocolSubmitActionService {
    
    /**
     * Finds all submissions for the given protocolNumber and calculates how many total submissions it has overall.
     * @param protocol protocol
     * @return the total number of submissions for the given protocolNumber
     */
    int getTotalSubmissions(IacucProtocol protocol);
    
    /**
     * Finds all submissions for the given protocolNumber.
     * @param protocolNumber The human-readable protocol number
     * @return the list of submissions for the given protocolNumber
     */
    List<IacucProtocolSubmission> getProtocolSubmissions(String protocolNumber);
    
    /**
     * Finds all submissions for the given protocolNumber and submissionNumber.
     * 
     * Note that there are multiple submissions for a given protocol since the submissions are copied when the protocol is versioned.
     * @param protocolNumber The human-readable protocol number
     * @param submissionNumber The submission number
     * @return the list of submissions for the given protocolNumber
     */
    List<IacucProtocolSubmission> getProtocolSubmissions(String protocolNumber, int submissionNumber);

    /**
     * Submit a protocol to the IACUC office for review.
     * @param protocol the protocol
     * @param submitAction the submission data
     * @throws Exception 
     */
    void submitToIacucForReview(IacucProtocol protocol, IacucProtocolSubmitAction submitAction) throws Exception;
    
    /**
     * 
     * This method for getting IacucProtocolSubmissionsLookup from given protocolNumber...
     * @param protocolNumber
     * @return
     * @throws Exception
     */
   
    public List<IacucProtocolSubmission> getProtocolSubmissionsLookupData(List<IacucProtocolSubmission> protocolSubmissionList) throws Exception;
}
