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
package org.kuali.kra.irb.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.web.struts.action.AbstractHoldingPageAction;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.util.GlobalVariables;


public class IrbHoldingPageAction extends AbstractHoldingPageAction {

    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        ActionForward forward = super.execute(mapping, form, request, response);
        
        Object documentId = GlobalVariables.getUserSession().retrieveObject(Constants.HOLDING_PAGE_DOCUMENT_ID);
        Document document = getDocumentService().getByDocumentHeaderId(documentId.toString());
        if (isDocumentPostprocessingComplete(document)) {
            String backLocation = (String) GlobalVariables.getUserSession().retrieveObject(Constants.HOLDING_PAGE_RETURN_LOCATION);
            GlobalVariables.getUserSession().removeObject(Constants.HOLDING_PAGE_RETURN_LOCATION);
            GlobalVariables.getUserSession().removeObject(Constants.HOLDING_PAGE_DOCUMENT_ID);

            forward = new ActionForward(backLocation, true);
        }
        
        return forward;
    }
   
}
