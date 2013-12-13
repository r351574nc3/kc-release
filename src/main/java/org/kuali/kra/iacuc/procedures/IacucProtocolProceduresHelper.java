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
package org.kuali.kra.iacuc.procedures;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.iacuc.IacucProtocolForm;
import org.kuali.kra.iacuc.auth.IacucProtocolTask;
import org.kuali.kra.infrastructure.KraServiceLocator;
import org.kuali.kra.infrastructure.TaskName;
import org.kuali.kra.protocol.auth.ProtocolTask;
import org.kuali.kra.service.TaskAuthorizationService;
import org.kuali.rice.krad.util.GlobalVariables;

public class IacucProtocolProceduresHelper implements Serializable{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -2090976351003068814L;

    protected IacucProtocolForm form;
    
    protected IacucProtocolStudyGroup newIacucProtocolStudyGroup;
    protected IacucProtocolStudyGroupBean newIacucProtocolStudyGroupBean;
    protected IacucProcedurePersonResponsible newIacucProcedurePersonResponsible;
    
    private List<IacucProcedure> allProcedures;
  
    protected int MAX_CATEGORY_COLUMNS = 3;
    
    public IacucProtocolProceduresHelper(IacucProtocolForm form) {
        setForm(form); 
        setNewIacucProtocolStudyGroup(new IacucProtocolStudyGroup());
        setNewIacucProtocolStudyGroupBean(new IacucProtocolStudyGroupBean());
        setNewIacucProcedurePersonResponsible(new IacucProcedurePersonResponsible());
        setAllProcedures(new ArrayList<IacucProcedure>());
        initializeIncludedProceduresAndCategories();
    }    
    
    
    public void prepareView() {
        //getForm().populateEditableFields();
        initializeIncludedProceduresAndCategories();
    }
    
    private void initializeIncludedProceduresAndCategories() {
        if(getAllProcedures().isEmpty()) {
            setAllProcedures(getIacucProtocolProcedureService().getAllProcedures());
        }
        if(getProtocol().getIacucProtocolStudyGroupBeans().isEmpty()) {
            getProtocol().setIacucProtocolStudyGroupBeans(getIacucProtocolProcedureService().getRevisedStudyGroupBeans(getProtocol(), getAllProcedures()));
        }
    }

    protected IacucProtocolProcedureService getIacucProtocolProcedureService() {
        return (IacucProtocolProcedureService)KraServiceLocator.getService("iacucProtocolProcedureService");
    }

    protected IacucProtocol getProtocol() {
        IacucProtocolDocument document = form.getIacucProtocolDocument();
        if (document == null || document.getProtocol() == null) {
            throw new IllegalArgumentException("invalid (null) Iacuc ProtocolDocument in ProtocolForm");
        }
        return document.getIacucProtocol();
    }
    
    public IacucProtocolForm getForm() {
        return form;
    }

    public void setForm(IacucProtocolForm form) {
        this.form = form;
    }

    public boolean isModifyProtocolProcedures() {
        final ProtocolTask task = new IacucProtocolTask(TaskName.MODIFY_IACUC_PROTOCOL_PROCEDURES, (IacucProtocol) form.getProtocolDocument().getProtocol());
        return getTaskAuthorizationService().isAuthorized(GlobalVariables.getUserSession().getPrincipalId(), task);
    }

    protected TaskAuthorizationService getTaskAuthorizationService() {
        return KraServiceLocator.getService(TaskAuthorizationService.class);
    }

    protected String getUserIdentifier() {
        return GlobalVariables.getUserSession().getPrincipalId();
    }

    public IacucProtocolStudyGroup getNewIacucProtocolStudyGroup() {
        return newIacucProtocolStudyGroup;
    }

    public void setNewIacucProtocolStudyGroup(IacucProtocolStudyGroup newIacucProtocolStudyGroup) {
        this.newIacucProtocolStudyGroup = newIacucProtocolStudyGroup;
    }


    public List<IacucProcedure> getAllProcedures() {
        return allProcedures;
    }

    public void setAllProcedures(List<IacucProcedure> allProcedures) {
        this.allProcedures = allProcedures;
    }


    public int getMaxCategoriesInAColumn() {
        return ((int) Math.ceil(getAllProcedures().size() / MAX_CATEGORY_COLUMNS)); 
    }


    public IacucProtocolStudyGroupBean getNewIacucProtocolStudyGroupBean() {
        return newIacucProtocolStudyGroupBean;
    }


    public void setNewIacucProtocolStudyGroupBean(IacucProtocolStudyGroupBean newIacucProtocolStudyGroupBean) {
        this.newIacucProtocolStudyGroupBean = newIacucProtocolStudyGroupBean;
    }


    public IacucProcedurePersonResponsible getNewIacucProcedurePersonResponsible() {
        return newIacucProcedurePersonResponsible;
    }


    public void setNewIacucProcedurePersonResponsible(IacucProcedurePersonResponsible newIacucProcedurePersonResponsible) {
        this.newIacucProcedurePersonResponsible = newIacucProcedurePersonResponsible;
    }

}
