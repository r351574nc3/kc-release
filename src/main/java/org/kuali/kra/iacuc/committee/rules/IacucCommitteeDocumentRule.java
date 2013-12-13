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
package org.kuali.kra.iacuc.committee.rules;

import org.kuali.kra.common.committee.bo.CommitteeBase;
import org.kuali.kra.common.committee.document.CommitteeDocumentBase;
import org.kuali.kra.common.committee.lookup.keyvalue.CommitteeIdValuesFinderBase;
import org.kuali.kra.common.committee.rules.CommitteeDocumentRuleBase;
import org.kuali.kra.iacuc.committee.bo.IacucCommittee;
import org.kuali.kra.iacuc.committee.document.CommonCommitteeDocument;
import org.kuali.kra.iacuc.committee.lookup.keyvalue.IacucCommitteeIdValuesFinder;

public class IacucCommitteeDocumentRule extends CommitteeDocumentRuleBase {

    @Override
    protected Class<? extends CommitteeBase> getCommitteeBOClassHook() {
        return IacucCommittee.class;
    }

    @Override
    protected CommitteeIdValuesFinderBase getNewCommitteeIdValuesFinderInstanceHook() {
        return new IacucCommitteeIdValuesFinder();        
    }

    @Override
    protected Class<? extends CommitteeDocumentBase> getCommitteeDocumentBOClassHook() {
        return CommonCommitteeDocument.class;
    }

}
