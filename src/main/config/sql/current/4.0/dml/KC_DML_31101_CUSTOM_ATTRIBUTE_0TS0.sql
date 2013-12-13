insert into CUSTOM_ATTRIBUTE (ID,NAME,LABEL,DATA_TYPE_CODE,DATA_LENGTH,DEFAULT_VALUE,LOOKUP_CLASS,LOOKUP_RETURN,GROUP_NAME,UPDATE_TIMESTAMP,UPDATE_USER,VER_NBR,OBJ_ID)
values (SEQ_CUSTOM_ATTRIBUTE.NEXTVAL,'ARRA_FUNDING','ARRA Funding','1',3,null,'org.kuali.kra.bo.ArgValueLookup','yes_no_flag','Other',sysdate,'admin',0,sys_guid())
/
insert into CUSTOM_ATTRIBUTE_DOCUMENT (DOCUMENT_TYPE_CODE,CUSTOM_ATTRIBUTE_ID,TYPE_NAME,IS_REQUIRED,UPDATE_TIMESTAMP,UPDATE_USER,VER_NBR,ACTIVE_FLAG,OBJ_ID)
 values ('PRDV',SEQ_CUSTOM_ATTRIBUTE.CURRVAL,null,'N',sysdate,'admin',0,'Y',sys_guid())
/
insert into CUSTOM_ATTRIBUTE_DOCUMENT(DOCUMENT_TYPE_CODE,CUSTOM_ATTRIBUTE_ID,TYPE_NAME,IS_REQUIRED,UPDATE_TIMESTAMP,UPDATE_USER,VER_NBR,ACTIVE_FLAG,OBJ_ID)
 values ('INPR',SEQ_CUSTOM_ATTRIBUTE.CURRVAL,null,'N',sysdate,'admin',0,'Y',sys_guid())
/
commit
/
