
CREATE TABLE VALID_PROTO_SUB_REV_TYPE ( 
    VALID_PROTO_SUB_REV_TYPE_ID NUMBER(12,0) NOT NULL, 
    SUBMISSION_TYPE_CODE VARCHAR2(3) NOT NULL, 
    PROTOCOL_REVIEW_TYPE_CODE VARCHAR2(3) NOT NULL, 
    UPDATE_TIMESTAMP DATE NOT NULL, 
    UPDATE_USER VARCHAR2(60) NOT NULL, 
    VER_NBR NUMBER(8,0) DEFAULT 1 NOT NULL, 
    OBJ_ID VARCHAR2(36) NULL);


-- Primary Key Constraint 
ALTER TABLE VALID_PROTO_SUB_REV_TYPE 
ADD CONSTRAINT PK_VALID_PROTO_SUB_REV_TYPE 
PRIMARY KEY (VALID_PROTO_SUB_REV_TYPE_ID);

-- *************** UNIQUE CONSTRAINT DEFINED FOR COMPOSITE KEY COLUMNS ************ 
ALTER TABLE VALID_PROTO_SUB_REV_TYPE 
ADD CONSTRAINT UQ_VALID_PROTO_SUB_REV_TYPE 
UNIQUE (SUBMISSION_TYPE_CODE, PROTOCOL_REVIEW_TYPE_CODE);

-- Foreign Key Constraint(s)
ALTER TABLE VALID_PROTO_SUB_REV_TYPE 
ADD CONSTRAINT FK2_VALID_PROTO_SUB_REV_TYPE 
FOREIGN KEY (PROTOCOL_REVIEW_TYPE_CODE) 
REFERENCES PROTOCOL_REVIEW_TYPE (PROTOCOL_REVIEW_TYPE_CODE);

ALTER TABLE VALID_PROTO_SUB_REV_TYPE 
ADD CONSTRAINT FK_VALID_PROTO_SUB_REV_TYPE 
FOREIGN KEY (SUBMISSION_TYPE_CODE) 
REFERENCES SUBMISSION_TYPE (SUBMISSION_TYPE_CODE);


CREATE TABLE VALID_PROTO_SUB_TYPE_QUAL ( 
    VALID_PROTO_SUB_TYPE_QUAL_ID NUMBER(12,0) NOT NULL, 
    SUBMISSION_TYPE_CODE VARCHAR2(3) NOT NULL, 
    SUBMISSION_TYPE_QUAL_CODE VARCHAR2(3) NOT NULL, 
    UPDATE_TIMESTAMP DATE NOT NULL, 
    UPDATE_USER VARCHAR2(60) NOT NULL, 
    VER_NBR NUMBER(8,0) DEFAULT 1 NOT NULL, 
    OBJ_ID VARCHAR2(36) NULL);


-- Primary Key Constraint 
ALTER TABLE VALID_PROTO_SUB_TYPE_QUAL 
ADD CONSTRAINT PK_VALID_PROTO_SUB_TYPE_QUAL 
PRIMARY KEY (VALID_PROTO_SUB_TYPE_QUAL_ID);

-- *************** UNIQUE CONSTRAINT DEFINED FOR COMPOSITE KEY COLUMNS ************ 
ALTER TABLE VALID_PROTO_SUB_TYPE_QUAL 
ADD CONSTRAINT UQ_VALID_PROTO_SUB_TYPE_QUAL 
UNIQUE (SUBMISSION_TYPE_CODE, SUBMISSION_TYPE_QUAL_CODE);

-- Foreign Key Constraint(s)
ALTER TABLE VALID_PROTO_SUB_TYPE_QUAL 
ADD CONSTRAINT FK_VALID_PROTO_SUB_TYPE_QUAL 
FOREIGN KEY (SUBMISSION_TYPE_CODE) 
REFERENCES SUBMISSION_TYPE (SUBMISSION_TYPE_CODE);

ALTER TABLE VALID_PROTO_SUB_TYPE_QUAL 
ADD CONSTRAINT FK2_VALID_PROTO_SUB_TYPE_QUAL 
FOREIGN KEY (SUBMISSION_TYPE_QUAL_CODE) 
REFERENCES SUBMISSION_TYPE_QUALIFIER (SUBMISSION_TYPE_QUAL_CODE);


CREATE SEQUENCE SEQ_VALID_SUBM_REVW_TYPE_QUAL INCREMENT BY 1 START WITH 1;


CREATE OR REPLACE VIEW OSP$VALID_PROTO_SUB_REV_TYPE AS SELECT 
    SUBMISSION_TYPE_CODE, 
    PROTOCOL_REVIEW_TYPE_CODE, 
    UPDATE_TIMESTAMP, 
    UPDATE_USER
FROM VALID_PROTO_SUB_REV_TYPE;


CREATE OR REPLACE VIEW OSP$VALID_PROTO_SUB_TYPE_QUAL AS SELECT 
    SUBMISSION_TYPE_CODE, 
    SUBMISSION_TYPE_QUAL_CODE, 
    UPDATE_TIMESTAMP, 
    UPDATE_USER
FROM VALID_PROTO_SUB_TYPE_QUAL;
