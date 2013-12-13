DELIMITER /
INSERT INTO KRIM_ROLE_PERM_ID_BS_S VALUES(NULL)
/
INSERT INTO KRIM_ROLE_PERM_T (ROLE_PERM_ID, OBJ_ID, VER_NBR, ROLE_ID, PERM_ID, ACTV_IND)
VALUES ((SELECT (MAX(ID)) FROM KRIM_ROLE_PERM_ID_BS_S), UUID(), '1', (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE ROLE_NM= 'Coi Disclosure Reviewer'),
(SELECT PERM_ID FROM KRIM_PERM_T WHERE NM = 'View Coi Restricted Notes'), 'Y')
/
INSERT INTO KRIM_ROLE_PERM_ID_BS_S VALUES(NULL)
/
INSERT INTO KRIM_ROLE_PERM_T (ROLE_PERM_ID, OBJ_ID, VER_NBR, ROLE_ID, PERM_ID, ACTV_IND)
VALUES ((SELECT (MAX(ID)) FROM KRIM_ROLE_PERM_ID_BS_S), UUID(), '1', (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE ROLE_NM= 'Coi Disclosure Reviewer'),
(SELECT PERM_ID FROM KRIM_PERM_T WHERE NM = 'Maintain Coi Disclosure Notes'), 'Y')
/
INSERT INTO KRIM_ROLE_PERM_ID_BS_S VALUES(NULL)
/
INSERT INTO KRIM_ROLE_PERM_T (ROLE_PERM_ID, OBJ_ID, VER_NBR, ROLE_ID, PERM_ID, ACTV_IND)
VALUES ((SELECT (MAX(ID)) FROM KRIM_ROLE_PERM_ID_BS_S), UUID(), '1', (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE ROLE_NM= 'Coi Disclosure Reviewer'),
(SELECT PERM_ID FROM KRIM_PERM_T WHERE NM = 'Maintain Coi Disclosure Attachments'), 'Y')
/
INSERT INTO KRIM_ROLE_PERM_ID_BS_S VALUES(NULL)
/
INSERT INTO KRIM_ROLE_PERM_T (ROLE_PERM_ID, OBJ_ID, VER_NBR, ROLE_ID, PERM_ID, ACTV_IND)
VALUES ((SELECT (MAX(ID)) FROM KRIM_ROLE_PERM_ID_BS_S), UUID(), '1', (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE ROLE_NM= 'Coi Disclosure Reviewer'),
(SELECT PERM_ID FROM KRIM_PERM_T WHERE NM = 'View Coi Disclosure'), 'Y')
/
DELIMITER ;
