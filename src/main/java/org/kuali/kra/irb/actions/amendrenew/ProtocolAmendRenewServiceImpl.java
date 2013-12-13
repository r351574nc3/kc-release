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
package org.kuali.kra.irb.actions.amendrenew;

import java.util.ArrayList;
import java.util.List;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.actions.ProtocolAction;
import org.kuali.kra.irb.actions.ProtocolActionType;
import org.kuali.kra.irb.actions.ProtocolStatus;
import org.kuali.kra.irb.questionnaire.ProtocolModuleQuestionnaireBean;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.actions.ProtocolActionBase;
import org.kuali.kra.protocol.actions.amendrenew.ProtocolAmendRenewModuleBase;
import org.kuali.kra.protocol.actions.amendrenew.ProtocolAmendRenewServiceImplBase;
import org.kuali.kra.protocol.actions.amendrenew.ProtocolAmendRenewalBase;
import org.kuali.kra.protocol.actions.amendrenew.ProtocolAmendmentBean;
import org.kuali.kra.questionnaire.answer.ModuleQuestionnaireBean;

/**
 * The Protocol Amendment/Renewal Service Implementation.
 */
public class ProtocolAmendRenewServiceImpl extends ProtocolAmendRenewServiceImplBase implements ProtocolAmendRenewService {

    @Override
    protected ProtocolActionBase getNewAmendmentProtocolActionInstanceHook(ProtocolBase protocol) {
        return new ProtocolAction((Protocol)protocol, ProtocolActionType.AMENDMENT_CREATED);
    }

    @Override
    protected ProtocolActionBase getNewRenewalProtocolActionInstanceHook(ProtocolBase protocol) {
        return new ProtocolAction((Protocol)protocol, ProtocolActionType.RENEWAL_CREATED);
    }

    @Override
    protected ModuleQuestionnaireBean getNewProtocolModuleQuestionnaireBeanInstanceHook(ProtocolBase protocol) {
        return new ProtocolModuleQuestionnaireBean((Protocol) protocol);
    }

    @Override
    protected String getAmendmentInProgressStatusHook() {
        return ProtocolStatus.AMENDMENT_IN_PROGRESS;
    }

    @Override
    protected String getRenewalInProgressStatusHook() {
        return ProtocolStatus.RENEWAL_IN_PROGRESS;
    }

    @Override
    protected List<String> getAllModuleTypeCodes() {
        List<String> moduleTypeCodes = new ArrayList<String>();
        moduleTypeCodes.add(ProtocolModule.GENERAL_INFO);
        moduleTypeCodes.add(ProtocolModule.ADD_MODIFY_ATTACHMENTS);
        moduleTypeCodes.add(ProtocolModule.AREAS_OF_RESEARCH);
        moduleTypeCodes.add(ProtocolModule.FUNDING_SOURCE);
        moduleTypeCodes.add(ProtocolModule.OTHERS);
        moduleTypeCodes.add(ProtocolModule.PROTOCOL_ORGANIZATIONS);
        moduleTypeCodes.add(ProtocolModule.PROTOCOL_PERSONNEL);
        moduleTypeCodes.add(ProtocolModule.PROTOCOL_REFERENCES);
        moduleTypeCodes.add(ProtocolModule.SPECIAL_REVIEW);
        moduleTypeCodes.add(ProtocolModule.SUBJECTS);
        moduleTypeCodes.add(ProtocolModule.PROTOCOL_PERMISSIONS);
        moduleTypeCodes.add(ProtocolModule.QUESTIONNAIRE);
        return moduleTypeCodes;
    }

    @Override
    protected void addModules(ProtocolBase protocol, ProtocolAmendmentBean amendmentBean) {
        ProtocolAmendRenewal amendmentEntry = (ProtocolAmendRenewal)protocol.getProtocolAmendRenewal();
        if (amendmentBean.getGeneralInfo()) {
            amendmentEntry.addModule(createModule(amendmentEntry, ProtocolModule.GENERAL_INFO));
        } else {
            protocol.merge(protocolFinderDao.findCurrentProtocolByNumber(protocol.getAmendedProtocolNumber()), ProtocolModule.GENERAL_INFO);
            amendmentEntry.removeModule(ProtocolModule.GENERAL_INFO);
        }
        
        if (amendmentBean.getAddModifyAttachments()) {
            amendmentEntry.addModule(createModule(amendmentEntry, ProtocolModule.ADD_MODIFY_ATTACHMENTS));
        } else {
            protocol.merge(protocolFinderDao.findCurrentProtocolByNumber(protocol.getAmendedProtocolNumber()), ProtocolModule.ADD_MODIFY_ATTACHMENTS);
            amendmentEntry.removeModule(ProtocolModule.ADD_MODIFY_ATTACHMENTS);
        }
        
        if (amendmentBean.getAreasOfResearch()) {
            amendmentEntry.addModule(createModule(amendmentEntry, ProtocolModule.AREAS_OF_RESEARCH));
        } else {
            protocol.merge(protocolFinderDao.findCurrentProtocolByNumber(protocol.getAmendedProtocolNumber()), ProtocolModule.AREAS_OF_RESEARCH);
            amendmentEntry.removeModule(ProtocolModule.AREAS_OF_RESEARCH);
        }
        
        if (amendmentBean.getFundingSource()) {
            amendmentEntry.addModule(createModule(amendmentEntry, ProtocolModule.FUNDING_SOURCE));
        } else {
            protocol.merge(protocolFinderDao.findCurrentProtocolByNumber(protocol.getAmendedProtocolNumber()), ProtocolModule.FUNDING_SOURCE);
            amendmentEntry.removeModule(ProtocolModule.FUNDING_SOURCE);
        }
        
        if (amendmentBean.getProtocolOrganizations()) {
            amendmentEntry.addModule(createModule(amendmentEntry, ProtocolModule.PROTOCOL_ORGANIZATIONS));
        } else {
            protocol.merge(protocolFinderDao.findCurrentProtocolByNumber(protocol.getAmendedProtocolNumber()), ProtocolModule.PROTOCOL_ORGANIZATIONS);
            amendmentEntry.removeModule(ProtocolModule.PROTOCOL_ORGANIZATIONS);
        }
        
        if (amendmentBean.getProtocolPersonnel()) {
            amendmentEntry.addModule(createModule(amendmentEntry, ProtocolModule.PROTOCOL_PERSONNEL));
        } else {
            protocol.merge(protocolFinderDao.findCurrentProtocolByNumber(protocol.getAmendedProtocolNumber()), ProtocolModule.PROTOCOL_PERSONNEL);
            amendmentEntry.removeModule(ProtocolModule.PROTOCOL_PERSONNEL);
        }
        
        if (amendmentBean.getProtocolReferencesAndOtherIdentifiers()) {
            amendmentEntry.addModule(createModule(amendmentEntry, ProtocolModule.PROTOCOL_REFERENCES));
        } else {
            protocol.merge(protocolFinderDao.findCurrentProtocolByNumber(protocol.getAmendedProtocolNumber()), ProtocolModule.PROTOCOL_REFERENCES);
            amendmentEntry.removeModule(ProtocolModule.PROTOCOL_REFERENCES);
        }
        
        if (amendmentBean.getSubjects()) {
            amendmentEntry.addModule(createModule(amendmentEntry, ProtocolModule.SUBJECTS));
        } else {
            protocol.merge(protocolFinderDao.findCurrentProtocolByNumber(protocol.getAmendedProtocolNumber()), ProtocolModule.SUBJECTS);
            amendmentEntry.removeModule(ProtocolModule.SUBJECTS);
        }
        
        if (amendmentBean.getSpecialReview()) {
            amendmentEntry.addModule(createModule(amendmentEntry, ProtocolModule.SPECIAL_REVIEW));
        } else {
            protocol.merge(protocolFinderDao.findCurrentProtocolByNumber(protocol.getAmendedProtocolNumber()), ProtocolModule.SPECIAL_REVIEW);
            amendmentEntry.removeModule(ProtocolModule.SPECIAL_REVIEW);
        }
        
        if (amendmentBean.getOthers()) {
            amendmentEntry.addModule(createModule(amendmentEntry, ProtocolModule.OTHERS));
        } else {
            protocol.merge(protocolFinderDao.findCurrentProtocolByNumber(protocol.getAmendedProtocolNumber()), ProtocolModule.OTHERS);
            amendmentEntry.removeModule(ProtocolModule.OTHERS);
        }
        
        if (amendmentBean.getProtocolPermissions()) {
            amendmentEntry.addModule(createModule(amendmentEntry, ProtocolModule.PROTOCOL_PERMISSIONS));
        } else {
            protocol.merge(protocolFinderDao.findCurrentProtocolByNumber(protocol.getAmendedProtocolNumber()), ProtocolModule.PROTOCOL_PERMISSIONS);
            amendmentEntry.removeModule(ProtocolModule.PROTOCOL_PERMISSIONS);
        }
        if (amendmentBean.getQuestionnaire()) {
            amendmentEntry.addModule(createModule(amendmentEntry, ProtocolModule.QUESTIONNAIRE));
        } else {
            removeEditedQuestionaire(protocol);
            amendmentEntry.removeModule(ProtocolModule.QUESTIONNAIRE);
        }

    }

    @Override
    protected Class<? extends ProtocolBase> getProtocolBOClassHook() {
        return Protocol.class;
    }

    @Override
    protected ProtocolAmendRenewalBase getNewProtocolAmendRenewalInstanceHook() {
        return new ProtocolAmendRenewal();
    }

    @Override
    protected ProtocolAmendRenewModuleBase getNewProtocolAmendRenewModuleInstanceHook() {
        return new ProtocolAmendRenewModule();
    }
}
