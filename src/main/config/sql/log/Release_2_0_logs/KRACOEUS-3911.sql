--delete from krew_rule_t where doc_typ_nm = 'ProposalDevelopmentDocument';
-- FOR USING NODE requests DepartmentReview

INSERT INTO KRIM_GRP_T ( GRP_ID, OBJ_ID, VER_NBR, GRP_NM, NMSPC_CD, GRP_DESC, KIM_TYP_ID, ACTV_IND, LAST_UPDT_DT )
VALUES
( '1000005', '17151AD4B0C79985E0404F8189D80E8B', 1, 'Proposal Development - Department Reviewers', 'KC-WKFLW', 'Reviewes for DepartmentalReview route node.', '1', 'Y', to_date('2010-04-14 09:11:00', 'YYYY-MM-DD HH24:MI:SS') );

INSERT INTO KRIM_GRP_T ( GRP_ID, OBJ_ID, VER_NBR, GRP_NM, NMSPC_CD, GRP_DESC, KIM_TYP_ID, ACTV_IND, LAST_UPDT_DT )
VALUES
( '1000006', '71151AD4B0C79985E0404F8189D80E8B', 1, 'Proposal Development - Custom Approval Reviewers', 'KC-WKFLW', 'Reviewes for CustomApproval route node.', '1', 'Y', to_date('2010-04-14 09:11:00', 'YYYY-MM-DD HH24:MI:SS') );

INSERT INTO KRIM_GRP_MBR_T ( GRP_MBR_ID, OBJ_ID, VER_NBR, GRP_ID, MBR_ID, MBR_TYP_CD, LAST_UPDT_DT )
VALUES
( '1376', '27151AD4B0C79985E0404F8189D80E8B', 1, 
(SELECT GRP_ID FROM KRIM_GRP_T WHERE GRP_NM = 'Proposal Development - Department Reviewers' AND NMSPC_CD = 'KC-WKFLW'), 
(SELECT PRNCPL_ID FROM KRIM_PRNCPL_T WHERE PRNCPL_NM = 'schulte'), 
'P', to_date('2010-04-14 09:11:00', 'YYYY-MM-DD HH24:MI:SS') );

INSERT INTO KRIM_GRP_MBR_T ( GRP_MBR_ID, OBJ_ID, VER_NBR, GRP_ID, MBR_ID, MBR_TYP_CD, LAST_UPDT_DT )
VALUES
( '1377', '72151AD4B0C79985E0404F8189D80E8B', 1, 
(SELECT GRP_ID FROM KRIM_GRP_T WHERE GRP_NM = 'Proposal Development - Custom Approval Reviewers' AND NMSPC_CD = 'KC-WKFLW'), 
(SELECT PRNCPL_ID FROM KRIM_PRNCPL_T WHERE PRNCPL_NM = 'schulte'), 
'P', to_date('2010-04-14 09:11:00', 'YYYY-MM-DD HH24:MI:SS') );


