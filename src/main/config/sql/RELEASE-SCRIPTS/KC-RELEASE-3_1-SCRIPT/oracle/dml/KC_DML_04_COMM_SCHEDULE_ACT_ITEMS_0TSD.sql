INSERT INTO COMM_SCHEDULE_ACT_ITEMS (COMM_SCHEDULE_ACT_ITEMS_ID,SCHEDULE_ID_FK,ACTION_ITEM_NUMBER,SCHEDULE_ACT_ITEM_TYPE_CODE,ITEM_DESCRIPTION,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_MEETING_ID.NEXTVAL,(SELECT ID FROM COMM_SCHEDULE WHERE SCHEDULED_DATE = '19-JUL-10'),1,(SELECT SCHEDULE_ACT_ITEM_TYPE_CODE FROM SCHEDULE_ACT_ITEM_TYPE WHERE DESCRIPTION = 'Other Business'),'Other business item','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO COMM_SCHEDULE_ACT_ITEMS (COMM_SCHEDULE_ACT_ITEMS_ID,SCHEDULE_ID_FK,ACTION_ITEM_NUMBER,SCHEDULE_ACT_ITEM_TYPE_CODE,ITEM_DESCRIPTION,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_MEETING_ID.NEXTVAL,(SELECT ID FROM COMM_SCHEDULE WHERE SCHEDULED_DATE = '19-JUL-10'),2,(SELECT SCHEDULE_ACT_ITEM_TYPE_CODE FROM SCHEDULE_ACT_ITEM_TYPE WHERE DESCRIPTION = 'New Member Consideration'),'New membership consideration item','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO COMM_SCHEDULE_ACT_ITEMS (COMM_SCHEDULE_ACT_ITEMS_ID,SCHEDULE_ID_FK,ACTION_ITEM_NUMBER,SCHEDULE_ACT_ITEM_TYPE_CODE,ITEM_DESCRIPTION,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_MEETING_ID.NEXTVAL,(SELECT ID FROM COMM_SCHEDULE WHERE SCHEDULED_DATE = '19-JUL-10'),3,(SELECT SCHEDULE_ACT_ITEM_TYPE_CODE FROM SCHEDULE_ACT_ITEM_TYPE WHERE DESCRIPTION = 'Non-Compliance'),'non-compliance item','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO COMM_SCHEDULE_ACT_ITEMS (COMM_SCHEDULE_ACT_ITEMS_ID,SCHEDULE_ID_FK,ACTION_ITEM_NUMBER,SCHEDULE_ACT_ITEM_TYPE_CODE,ITEM_DESCRIPTION,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_MEETING_ID.NEXTVAL,(SELECT ID FROM COMM_SCHEDULE WHERE SCHEDULED_DATE = '19-JUL-10'),4,(SELECT SCHEDULE_ACT_ITEM_TYPE_CODE FROM SCHEDULE_ACT_ITEM_TYPE WHERE DESCRIPTION = 'Protocol Deviation'),'Protocol deviation item','quickstart',SYSDATE,SYS_GUID(),0)
/
INSERT INTO COMM_SCHEDULE_ACT_ITEMS (COMM_SCHEDULE_ACT_ITEMS_ID,SCHEDULE_ID_FK,ACTION_ITEM_NUMBER,SCHEDULE_ACT_ITEM_TYPE_CODE,ITEM_DESCRIPTION,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR) 
    VALUES (SEQ_MEETING_ID.NEXTVAL,(SELECT ID FROM COMM_SCHEDULE WHERE SCHEDULED_DATE = '19-JUL-10'),5,(SELECT SCHEDULE_ACT_ITEM_TYPE_CODE FROM SCHEDULE_ACT_ITEM_TYPE WHERE DESCRIPTION = 'Adverse Event'),'Adverse event item','quickstart',SYSDATE,SYS_GUID(),0)
/
