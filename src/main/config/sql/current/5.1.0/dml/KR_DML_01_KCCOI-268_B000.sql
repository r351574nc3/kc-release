INSERT INTO KRIM_ROLE_PERM_T (ROLE_PERM_ID, OBJ_ID, VER_NBR, ROLE_ID, PERM_ID, ACTV_IND)
       VALUES (KRIM_ROLE_PERM_ID_BS_S.NEXTVAL, SYS_GUID(), 1, 
               (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE ROLE_NM='COI Administrator'),
               (SELECT PERM_ID FROM KRIM_PERM_T WHERE NM='Maintain Questionnaire Usage' AND NMSPC_CD='KC-COIDISCLOSURE'), 'Y')
/
INSERT INTO KRIM_ROLE_PERM_T (ROLE_PERM_ID, OBJ_ID, VER_NBR, ROLE_ID, PERM_ID, ACTV_IND)
       VALUES (KRIM_ROLE_PERM_ID_BS_S.NEXTVAL, SYS_GUID(), 1, 
               (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE ROLE_NM='COI Administrator'),
               (SELECT PERM_ID FROM KRIM_PERM_T WHERE NM='Modify Questionnaire' AND NMSPC_CD='KC-QUESTIONNAIRE'), 'Y')
/
INSERT INTO KRIM_ROLE_PERM_T (ROLE_PERM_ID, OBJ_ID, VER_NBR, ROLE_ID, PERM_ID, ACTV_IND)
       VALUES (KRIM_ROLE_PERM_ID_BS_S.NEXTVAL, SYS_GUID(), 1, 
               (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE ROLE_NM='COI Administrator'),
               (SELECT PERM_ID FROM KRIM_PERM_T WHERE NM='Modify Question' and nmspc_cd='KC-QUESTIONNAIRE'), 'Y')
/
INSERT INTO KRIM_ROLE_PERM_T (ROLE_PERM_ID, OBJ_ID, VER_NBR, ROLE_ID, PERM_ID, ACTV_IND)
       VALUES (KRIM_ROLE_PERM_ID_BS_S.NEXTVAL, SYS_GUID(), 1, 
               (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE ROLE_NM='IACUC Administrator'),
               (SELECT PERM_ID FROM KRIM_PERM_T WHERE NM='Modify Questionnaire' AND NMSPC_CD='KC-QUESTIONNAIRE'), 'Y')
/
INSERT INTO KRIM_ROLE_PERM_T (ROLE_PERM_ID, OBJ_ID, VER_NBR, ROLE_ID, PERM_ID, ACTV_IND)
       VALUES (KRIM_ROLE_PERM_ID_BS_S.NEXTVAL, SYS_GUID(), 1, 
               (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE ROLE_NM='IACUC Administrator'),
               (SELECT PERM_ID FROM KRIM_PERM_T WHERE NM='Modify Question' and nmspc_cd='KC-QUESTIONNAIRE'), 'Y')
/
