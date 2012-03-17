CREATE TABLE FIN_OBJECT_CODE_MAPPING 
  ( 
    FIN_OBJECT_CODE varchar2(10) not null,
    RATE_TYPE_CODE varchar2(3) not null,
    OBJ_ID VARCHAR2(36),
    UNIT_NUMBER VARCHAR2(8) not null,
    RATE_CLASS_CODE VARCHAR2(3) not null,
    ACTIVITY_TYPE_CODE VARCHAR2(3),
    VER_NBR NUMBER(8,0) NOT NULL,
    MAPPING_ID NUMBER(12, 0)
  )
/
ALTER TABLE FIN_OBJECT_CODE_MAPPING
    ADD CONSTRAINT PK_MAPPING_ID
    PRIMARY KEY (MAPPING_ID)
/

