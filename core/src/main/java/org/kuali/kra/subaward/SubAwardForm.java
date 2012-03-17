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
package org.kuali.kra.subaward;

import java.util.Map;

import org.kuali.kra.web.struts.form.Auditable;
import org.kuali.kra.web.struts.form.KraTransactionalDocumentFormBase;
import org.kuali.kra.common.customattributes.CustomDataForm;
import org.kuali.kra.common.permissions.web.struts.form.PermissionsForm;
import org.kuali.kra.common.permissions.web.struts.form.PermissionsHelperBase;
import org.kuali.kra.medusa.MedusaBean;
import org.kuali.kra.subaward.bo.SubAward;
import org.kuali.kra.subaward.bo.SubAwardAmountInfo;
import org.kuali.kra.subaward.bo.SubAwardAmountReleased;
import org.kuali.kra.subaward.bo.SubAwardCloseout;
import org.kuali.kra.subaward.bo.SubAwardContact;
import org.kuali.kra.subaward.bo.SubAwardFundingSource;
import org.kuali.kra.subaward.document.SubAwardDocument;
import org.kuali.rice.kew.util.KEWConstants;
import org.kuali.rice.kns.web.ui.HeaderField;
import org.kuali.rice.kns.workflow.service.KualiWorkflowDocument;
import org.kuali.kra.subaward.customdata.CustomDataHelper;
public class SubAwardForm extends KraTransactionalDocumentFormBase implements PermissionsForm,CustomDataForm,Auditable{
    
    private static final long serialVersionUID = -1452575757578523254L;

    
    public static final String COLUMN = ":";
    private String lookupResultsSequenceNumber;
    private String lookupResultsBOClassName;
    private SubAwardCloseout newSubAwardCloseout;
    private SubAwardFundingSource newSubAwardFundingSource;  
    private SubAwardAmountInfo newSubAwardAmountInfo;
    private SubAwardContact newSubAwardContact;
    private SubAwardAmountReleased newSubAwardAmountReleased;
    private CustomDataHelper customDataHelper = new CustomDataHelper(this);
    private boolean auditActivated;
    private MedusaBean medusaBean;
    
    public boolean isAuditActivated() {
        return auditActivated;
    }

    public void setAuditActivated(boolean auditActivated) {
        this.auditActivated = auditActivated;
    }

    public SubAwardFundingSource getNewSubAwardFundingSource() {
        return newSubAwardFundingSource;
    }

    public void setNewSubAwardFundingSource(SubAwardFundingSource newSubAwardFundingSource) {
        this.newSubAwardFundingSource = newSubAwardFundingSource;
    }

    public SubAwardAmountInfo getNewSubAwardAmountInfo() {
        return newSubAwardAmountInfo;
    }

    public void setNewSubAwardAmountInfo(SubAwardAmountInfo newSubAwardAmountInfo) {
        this.newSubAwardAmountInfo = newSubAwardAmountInfo;
    }

    public SubAwardAmountReleased getNewSubAwardAmountReleased() {
        return newSubAwardAmountReleased;
    }

    public void setNewSubAwardAmountReleased(SubAwardAmountReleased newSubAwardAmountReleased) {
        this.newSubAwardAmountReleased = newSubAwardAmountReleased;
    }

    public CustomDataHelper getCustomDataHelper() {
        return customDataHelper;
    }

    public void setCustomDataHelper(CustomDataHelper customDataHelper) {
        this.customDataHelper = customDataHelper;
    }

    public SubAwardForm() {
        super();
        initialize();
    } 
   private SubAward subAward;
    
   
    /**
     * 
     * This method initialize all form variables
     */
    public void initialize() {
        medusaBean = new MedusaBean();
    }
  
    /**
     * 
     * This method returns the SubAwardDocument object.
     * @return
     */
    public SubAwardDocument getSubAwardDocument() {
        return (SubAwardDocument) super.getDocument();
    }
    /**
     * This method returns a string representation of the document type
     * @return
     */
    public String getDocumentTypeName() {
        return "SubAwardDocument";
    }
    /**
     * 
     * @see org.kuali.rice.kns.web.struts.form.KualiDocumentFormBase#populateHeaderFields(org.kuali.rice.kns.workflow.service.KualiWorkflowDocument)
     */
    @Override
    public void populateHeaderFields(KualiWorkflowDocument workflowDocument) {
         super.populateHeaderFields(workflowDocument);

        SubAwardDocument subAwardDocument = getDocument();
        getDocInfo().clear();
        String docIdAndStatus = COLUMN;
        if (workflowDocument != null) {
            docIdAndStatus = getDocument().getDocumentNumber() + COLUMN + workflowDocument.getStatusDisplayValue();
        }
        String lastUpdated ="";
        if(subAwardDocument.getSubAward().getUpdateTimestamp()!=null && subAwardDocument.getSubAward().getUpdateUser()!=null){
            
            lastUpdated = subAwardDocument.getSubAward().getUpdateTimestamp().toString() +" By " +  subAwardDocument.getSubAward().getUpdateUser();
        }
        
        getDocInfo().add(new HeaderField("DataDictionary.SubAward.attributes.requisitionerId",subAwardDocument.getSubAward().getRequisitionerName()));
        getDocInfo().add(new HeaderField("DataDictionary.SubAward.attributes.docIdStatus", docIdAndStatus));
        if(subAwardDocument.getSubAward().getUnit()!=null){
            getDocInfo().add(new HeaderField("DataDictionary.SubAward.attributes.requisitionerUnit",subAwardDocument.getSubAward().getUnit().getUnitName()));
        }else{
            getDocInfo().add(new HeaderField("DataDictionary.SubAward.attributes.requisitionerUnit",""));

        }
        getDocInfo().add(new HeaderField("DataDictionary.SubAward.attributes.subAwardId",subAwardDocument.getSubAward().getSubAwardCode()));
        getDocInfo().add(new HeaderField("DataDictionary.SubAward.attributes.organizationId",subAwardDocument.getSubAward().getOrganizationName()));
        getDocInfo().add(new HeaderField("DataDictionary.SubAward.attributes.lastUpdate",lastUpdated));


    }
    /**
     * Retrieves the {@link SubAwardDocument SubAwardDocument}.
     * @return {@link SubAwardDocument SubAwardDocument}
     */
    @Override
    public SubAwardDocument getDocument() {
        return (SubAwardDocument) super.getDocument();
    }
    
    /**
     * 
     * This method initializes either the document or the form based on the command value.
     */
    public void initializeFormOrDocumentBasedOnCommand(){
        if (KEWConstants.INITIATE_COMMAND.equals(getCommand())) {
            getDocument().initialize();
        }else{
            initialize();
        }
    }
    
    
    @Override
    protected String getLockRegion() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void setSaveDocumentControl(Map editMode) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected String getDefaultDocumentTypeName() {
        return "SubAwardDocument";
    }
   
    public SubAward getSubAward() {
        return subAward;
    }

    public void setLookupResultsSequenceNumber(String lookupResultsSequenceNumber) {
        this.lookupResultsSequenceNumber = lookupResultsSequenceNumber;
    }

    public String getLookupResultsSequenceNumber() {
        return lookupResultsSequenceNumber;
    }

    public void setLookupResultsBOClassName(String lookupResultsBOClassName) {
        this.lookupResultsBOClassName = lookupResultsBOClassName;
    }

    public String getLookupResultsBOClassName() {
        return lookupResultsBOClassName;
    }

    public PermissionsHelperBase getPermissionsHelper() {
        // TODO Auto-generated method stub
        return null;
    }

    public void setNewSubAwardCloseout(SubAwardCloseout newSubAwardCloseout) {
        this.newSubAwardCloseout = newSubAwardCloseout;
    }

    public SubAwardCloseout getNewSubAwardCloseout() {
        return newSubAwardCloseout;
    }

   

    public void setNewSubAwardContact(SubAwardContact newSubAwardContact) {
        this.newSubAwardContact = newSubAwardContact;
    }

    public SubAwardContact getNewSubAwardContact() {
        return newSubAwardContact;
    }

    /**
     * Gets the medusaBean attribute. 
     * @return Returns the medusaBean.
     */
    public MedusaBean getMedusaBean() {
        return medusaBean;
    }

    /**
     * Sets the medusaBean attribute value.
     * @param medusaBean The medusaBean to set.
     */
    public void setMedusaBean(MedusaBean medusaBean) {
        this.medusaBean = medusaBean;
    }
  

}
