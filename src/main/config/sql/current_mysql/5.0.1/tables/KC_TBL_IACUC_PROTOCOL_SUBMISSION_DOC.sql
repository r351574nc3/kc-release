DELIMITER /
ALTER TABLE IACUC_PROTOCOL_SUBMISSION_DOC ADD SUBMISSION_DOC_ID DECIMAL(12)
/

ALTER TABLE IACUC_PROTOCOL_SUBMISSION_DOC
ADD CONSTRAINT PK_IACUC_PROTO_SUBMISSION_DOC
PRIMARY KEY (SUBMISSION_DOC_ID)
/

ALTER TABLE IACUC_PROTOCOL_SUBMISSION_DOC ADD PROTOCOL_ID DECIMAL(12,0) NOT NULL
/

ALTER TABLE IACUC_PROTOCOL_SUBMISSION_DOC ADD SUBMISSION_ID_FK DECIMAL(12,0) NOT NULL
/

ALTER TABLE IACUC_PROTOCOL_SUBMISSION_DOC
ADD CONSTRAINT FK_IACUC_PROTO_SUBMISSION_DOC1
FOREIGN KEY (PROTOCOL_ID) 
REFERENCES IACUC_PROTOCOL (PROTOCOL_ID)
/

ALTER TABLE IACUC_PROTOCOL_SUBMISSION_DOC
ADD CONSTRAINT FK_IACUC_PROTO_SUBMISSION_DOC2
FOREIGN KEY (SUBMISSION_ID_FK) 
REFERENCES IACUC_PROTOCOL_SUBMISSION (IACUC_PROTOCOL_SUBMISSION_ID)
/

DELIMITER ;
