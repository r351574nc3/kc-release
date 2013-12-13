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
package org.kuali.kra.common.committee.lookup.keyvalue;

import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.kuali.kra.common.committee.bo.CommitteeBase;
import org.kuali.kra.infrastructure.KraServiceLocator;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondenceTemplateBase;
import org.kuali.kra.lookup.keyvalue.KeyValueComparator;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.keyvalues.KeyValuesBase;
import org.kuali.rice.krad.service.BusinessObjectService;

/**
 * 
 * This class is to create key/values pair of active committees.
 */
public abstract class CommitteeIdValuesFinderBase extends KeyValuesBase {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -2721177236491755020L;
    
    private List<ProtocolCorrespondenceTemplateBase> correspondenceTemplates;
    private BusinessObjectService businessObjectService;
    
    
    public BusinessObjectService getBusinessObjectService() {
        if(null == this.businessObjectService) {
            this.setBusinessObjectService(KraServiceLocator.getService(BusinessObjectService.class));
        }
        return this.businessObjectService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }

    /**
     * This method will return the list of all highest-sequence number committee instances.
     * Will always return non-null (but possibly empty) collection.
     */
    public List<CommitteeBase> getActiveCommittees() {
        ArrayList<CommitteeBase> returnCommitteeList = new ArrayList<CommitteeBase>();
        
// TODO *********commented the code below during IACUC refactoring*********         
//        Collection<CommonCommittee> committees = this.getBusinessObjectService().findAll(CommonCommittee.class);
        
        Collection<? extends CommitteeBase> committees = this.getBusinessObjectService().findAll(getCommitteeBOClassHook());
        // sort and iterate through to get only the latest instances
        if (CollectionUtils.isNotEmpty(committees)) {
            List<String> committeeIds = new ArrayList<String>();
            // only the active ones
            Collections.sort((List<CommitteeBase>) committees, Collections.reverseOrder());
            for (CommitteeBase committee : committees) {
                if (!committeeIds.contains(committee.getCommitteeId())) {
                    returnCommitteeList.add(committee); 
                    committeeIds.add(committee.getCommitteeId());
                }
            }
        }
        
        return returnCommitteeList;
    }
    
    protected abstract Class<? extends CommitteeBase> getCommitteeBOClassHook();

    /**
     * @return the list of &lt;key, value&gt; pairs of committees. The first entry is always &lt;"", "select:"&gt;.
     * @see org.kuali.core.lookup.keyvalues.KeyValuesFinder#getKeyValues()
     */
    @SuppressWarnings("unchecked")
    public List<KeyValue> getKeyValues() {

        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        // only the active ones
        Collection<CommitteeBase> committees = this.getActiveCommittees();
        if (CollectionUtils.isNotEmpty(committees)) {
            // get the exclusion list
            List<String> excludedCommitteeIds = getExcludedCommitteeIds();
            for (CommitteeBase committee : committees) {
                if (!excludedCommitteeIds.contains(committee.getCommitteeId())) {
                    keyValues.add(new ConcreteKeyValue(committee.getCommitteeId(), committee.getCommitteeName()));
                }
            }

            sort(keyValues, new KeyValueComparator());
        }

        keyValues.add(0, new ConcreteKeyValue("", "select"));
        
        return keyValues;
    }
    
    private List<String> getExcludedCommitteeIds() {
        List<String> committeeIds = new ArrayList<String>();

        if (CollectionUtils.isNotEmpty(correspondenceTemplates)) {
            for (ProtocolCorrespondenceTemplateBase correspondenceTemplate : correspondenceTemplates) {
                committeeIds.add(correspondenceTemplate.getCommitteeId());
            }
        }

        return committeeIds;
    }

    public List<ProtocolCorrespondenceTemplateBase> getCorrespondenceTemplates() {
        return correspondenceTemplates;
    }

    public void setCorrespondenceTemplates(List<ProtocolCorrespondenceTemplateBase> correspondenceTemplates) {
        this.correspondenceTemplates = correspondenceTemplates;
    }

}
