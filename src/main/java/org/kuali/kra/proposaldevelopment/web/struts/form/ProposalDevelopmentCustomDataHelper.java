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
package org.kuali.kra.proposaldevelopment.web.struts.form;

import java.util.List;
import java.util.Map;

import org.kuali.kra.bo.CustomAttributeDocValue;
import org.kuali.kra.bo.CustomAttributeDocument;
import org.kuali.kra.common.customattributes.CustomDataHelperBase;
import org.kuali.kra.document.ResearchDocumentBase;

public class ProposalDevelopmentCustomDataHelper extends CustomDataHelperBase<CustomAttributeDocValue> {
    
    private static final long serialVersionUID = 4399783400354474904L;
    private ProposalDevelopmentForm form;
    
    public ProposalDevelopmentCustomDataHelper(ProposalDevelopmentForm form) {
        this.form = form;
    }

    @Override
    protected CustomAttributeDocValue getNewCustomData() {
        return new CustomAttributeDocValue();
    }

    @Override
    public List<CustomAttributeDocValue> getCustomDataList() {
        return form.getProposalDevelopmentDocument().getCustomDataList();
    }

    @Override
    public Map<String, CustomAttributeDocument> getCustomAttributeDocuments() {
        return form.getProposalDevelopmentDocument().getCustomAttributeDocuments();
    }

}
