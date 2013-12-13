DELIMITER /
CREATE TABLE IACUC_PROTOCOL_ONLN_RVWS  ( 
    PROTOCOL_ONLN_RVW_ID            DECIMAL(12,0) NOT NULL,
    DOCUMENT_NUMBER                 VARCHAR(40) NOT NULL,
    PROTOCOL_ID                     DECIMAL(12,0) NULL,
    SUBMISSION_ID_FK                DECIMAL(12,0) NULL,
    PROTOCOL_REVIEWER_FK            DECIMAL(12,0) NOT NULL,
    PROTOCOL_ONLN_RVW_STATUS_CODE   VARCHAR(3) NOT NULL,
    REVIEW_DETERM_RECOM_CD          DECIMAL(3,0) NULL,
    DATE_REQUESTED                  DATE NOT NULL,
    DATE_DUE                        DATE NULL,
    UPDATE_TIMESTAMP                DATE NOT NULL,
    UPDATE_USER                     VARCHAR(60) NOT NULL,
    VER_NBR                         DECIMAL(8,0) NOT NULL,
    OBJ_ID                          VARCHAR(36) NOT NULL,
    ACTIONS_PERFORMED               VARCHAR(1000) NULL,
    REVIEWER_APPROVED               CHAR(1) NOT NULL,
    DETERMINE_REVIEW_TYPE_CD          DECIMAL(3,0) NULL,
    DETERMINE_REVIEW_DATE_DUE          DATE NULL,
    ADMIN_ACCEPTED                  CHAR(1) NOT NULL) ENGINE InnoDB CHARACTER SET utf8 COLLATE utf8_bin
/
ALTER TABLE IACUC_PROTOCOL_ONLN_RVWS 
ADD CONSTRAINT PK_IACUC_PROTOCOL_ONLN_RVWS 
PRIMARY KEY (PROTOCOL_ONLN_RVW_ID) 
/
DELIMITER ;
