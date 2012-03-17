insert into sh_parm_nmspc_t(SH_PARM_NMSPC_CD,SH_PARM_NMSPC_NM,ACTIVE_IND) values('KRA-PD','Proposal Development','Y');

insert into sh_parm_dtl_typ_t(SH_PARM_NMSPC_CD,SH_PARM_DTL_TYP_CD,SH_PARM_DTL_TYP_NM,ACTIVE_IND) values ('KRA-PD','D','Document','Y');
insert into sh_parm_dtl_typ_t(SH_PARM_NMSPC_CD,SH_PARM_DTL_TYP_CD,SH_PARM_DTL_TYP_NM,ACTIVE_IND) values ('KRA-PD','L','Lookup','Y');
insert into sh_parm_dtl_typ_t(SH_PARM_NMSPC_CD,SH_PARM_DTL_TYP_CD,SH_PARM_DTL_TYP_NM,ACTIVE_IND) values ('KRA-PD','A','All','Y');

insert into sh_parm_typ_t (sh_parm_typ_cd, sh_parm_typ_nm, active_ind) values ('HELP','Help','Y');

insert into sh_parm_typ_t (sh_parm_typ_cd, sh_parm_typ_nm, active_ind) values ('CONFG','System Configuration','Y');

insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KRA-PD','L','multipleValueLookupResultsPerPage','CONFG','200','Limit results returned for lookup - multiple results','A','Y');
insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KRA-PD','D','proposaldevelopment.creditsplit.enabled','CONFG','Y','Determines whether the Credit Split is turned on for proposal','A','Y');
insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KRA-PD','D','proposaldevelopment.personrole.nonnih.kp','CONFG','Key Person','Description of key person for Non-NIH Proposals','A','Y');
insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KRA-PD','D','proposaldevelopment.personrole.nonnih.pi','CONFG','Proposal Investigator Contact','Description of principal investigator contact for Non-NIH Proposals','A','Y');
insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KRA-PD','D','proposaldevelopment.personrole.nonnih.coi','CONFG','Proposal Investigator Multiple','Description of principal investigator multiple for Non-NIH Proposals','A','Y');
insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KRA-PD','D','proposaldevelopment.proposaltype.new','CONFG','1','ProposalTypeCode of NEW','A','Y');
insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KRA-PD','D','proposaldevelopment.proposaltype.renewal','CONFG','3','ProposalTypeCode of RENEWAL','A','Y');
insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KRA-PD','D','proposaldevelopment.proposaltype.revision','CONFG','5','ProposalTypeCode of REVISION','A','Y');
insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KRA-PD','D','proposaldevelopment.proposaltype.continuation','CONFG','2','ProposalTypeCode of CONTINUATION','A','Y');
insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KRA-PD','D','proposaldevelopment.displayKeywordPanel','CONFG','TRUE','Display Proposal Keyword panel','A','Y');
insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KRA-PD','D','proposaldevelopment.personrole.kp','CONFG','Key Person','Description of key person for NIH Proposals','A','Y');
insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KRA-PD','D','proposaldevelopment.personrole.coi','CONFG','Co-Investigator','Description of co-investigator for NIH Proposals','A','Y');
insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KRA-PD','D','proposaldevelopment.personrole.pi','CONFG','Principal Investigator','Description of principal investigator for NIH Proposals','A','Y');
insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KRA-PD','D','proposalNarrativeTypeGroup','CONFG','P','Define Narrative Type Group for Proposal Attachments','A','Y');
insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KRA-PD','D','instituteNarrativeTypeGroup','CONFG','O','Define Narrative Type Group for Institute Attachments','A','Y');
insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KRA-PD','D','deliveryInfoDisplayIndicator','CONFG','Y','Flag to display delivery infor panel','A','Y');

insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KR-NS','Lookup','MULTIPLE_VALUE_RESULTS_PER_PAGE','CONFG','200','Limit results returned for lookup - multiple results','A','Y');
insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KR-NS','Lookup','RESULTS_LIMIT','CONFG','200','Limit results returned for lookup','A','Y');

insert into sh_parm_nmspc_t(SH_PARM_NMSPC_CD,SH_PARM_NMSPC_NM,ACTIVE_IND) values('KRA-B','Budget','Y');
insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KRA-B','D','budgetStatusCompleteCode','CONFG','1','Code corresponding to the budget status of Complete','A','Y');
insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KRA-B','D','budgetStatusIncompleteCode','CONFG','2','Code corresponding to the budget status of Incomplete','A','Y');

insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KRA-B','D','defaultOverheadRateClassCode','CONFG','1','The overhead rate class a new Budget should default to','A','Y');
insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KRA-B','D','defaultUnderrecoveryRateClassCode','CONFG','1','The underrecovery rate class a new Budget should default to','A','Y');
insert into sh_parm_t (sh_parm_nmspc_cd,sh_parm_dtl_typ_cd,sh_parm_nm,sh_parm_typ_cd,sh_parm_txt,sh_parm_desc,sh_parm_cons_cd,active_ind) values ('KRA-B','D','defaultModularFlag','CONFG','N','Default value of modular flag for a new Budget.','A','Y');
