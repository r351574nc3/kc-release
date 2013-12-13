INSERT INTO IACUC_PROTOCOL_ACTION_TYPE ( PROTOCOL_ACTION_TYPE_CODE, DESCRIPTION, TRIGGER_SUBMISSION, TRIGGER_CORRESPONDENCE, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID )
       VALUES ( '908', 'Review Type Determination', 'N', 'N', SYSDATE, 'admin', SYS_GUID() )
/
INSERT INTO NOTIFICATION_TYPE (NOTIFICATION_TYPE_ID, MODULE_CODE, ACTION_CODE, DESCRIPTION, SUBJECT, MESSAGE, PROMPT_USER, SEND_NOTIFICATION, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID)
       VALUES (SEQ_NOTIFICATION_TYPE_ID.NEXTVAL, (SELECT MODULE_CODE FROM COEUS_MODULE WHERE DESCRIPTION='IACUC Protocol'),'908','IACUC Protocol Review Type Determination','IACUC Protocol {PROTOCOL_NUMBER} Review Type Determination Action','The protocol number <a title="" target="_self" href="{DOCUMENT_PREFIX}/kew/DocHandler.do?command=displayDocSearchView&amp;docId={DOCUMENT_NUMBER}">{PROTOCOL_NUMBER}</a>, Principal Investigator {PI_NAME} has had the action "Review Type Determination" performed on it.<br />The action was executed by {USER_FULLNAME}.  Determination is due by {DUE_DATE}. Additional information and further actions can be accessed through the Kuali Coeus system.','Y','N','admin',SYSDATE,1,SYS_GUID())
/
INSERT INTO NOTIFICATION_TYPE_RECIPIENT (NOTIFICATION_TYPE_RECIPIENT_ID, NOTIFICATION_TYPE_ID, ROLE_NAME, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID, ROLE_SUB_QUALIFIER)
       VALUES (SEQ_NOTIFICATION_TYPE_ID.NEXTVAL,(SELECT NOTIFICATION_TYPE_ID FROM NOTIFICATION_TYPE WHERE MODULE_CODE=9 AND ACTION_CODE='908'),'KC-IACUC:PI','admin',SYSDATE,1,SYS_GUID(), null)
/
INSERT INTO NOTIFICATION_TYPE_RECIPIENT (NOTIFICATION_TYPE_RECIPIENT_ID, NOTIFICATION_TYPE_ID, ROLE_NAME, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID, ROLE_SUB_QUALIFIER)
       VALUES (SEQ_NOTIFICATION_TYPE_ID.NEXTVAL,(SELECT NOTIFICATION_TYPE_ID FROM NOTIFICATION_TYPE WHERE MODULE_CODE=9 AND ACTION_CODE='908'),'KC-UNT:IACUC Administrator','admin',SYSDATE,1,SYS_GUID(),null)
/
INSERT INTO NOTIFICATION_TYPE_RECIPIENT (NOTIFICATION_TYPE_RECIPIENT_ID, NOTIFICATION_TYPE_ID, ROLE_NAME, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID, ROLE_SUB_QUALIFIER)
       VALUES (SEQ_NOTIFICATION_TYPE_ID.NEXTVAL,(SELECT NOTIFICATION_TYPE_ID FROM NOTIFICATION_TYPE WHERE MODULE_CODE=9 AND ACTION_CODE='908'),'KC-IACUC:Active Committee Member On Iacuc Protocol','admin',SYSDATE,1,SYS_GUID(),null)
/
