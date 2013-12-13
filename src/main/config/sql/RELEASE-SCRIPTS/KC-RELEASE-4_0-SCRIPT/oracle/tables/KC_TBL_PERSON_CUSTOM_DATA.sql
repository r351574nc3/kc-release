CREATE TABLE PERSON_CUSTOM_DATA (
    PERSON_CUSTOM_DATA_ID   NUMBER(8) NOT NULL,
    PERSON_ID               NUMBER(22) NOT NULL,
    CUSTOM_ATTRIBUTE_ID     NUMBER(12) NOT NULL,
    VALUE                   VARCHAR2(2000),
    UPDATE_USER             VARCHAR2(60) NOT NULL,
    UPDATE_TIMESTAMP        DATE NOT NULL,
    OBJ_ID                  VARCHAR2(36) NOT NULL,
    VER_NBR                 NUMBER(8) DEFAULT 1 NOT NULL
)
/
ALTER TABLE PERSON_CUSTOM_DATA ADD CONSTRAINT PK_PERSON_CUSTOM_DATA
  PRIMARY KEY (PERSON_CUSTOM_DATA_ID)
/
