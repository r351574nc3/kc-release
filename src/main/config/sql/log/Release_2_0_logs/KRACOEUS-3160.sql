CREATE SEQUENCE SEQ_PERSON_DEGREE INCREMENT BY 1 START WITH 1000 NOCYCLE;
ALTER TABLE PERSON_DEGREE DROP PRIMARY KEY;
ALTER TABLE PERSON_DEGREE DROP COLUMN DEGREE_SEQUENCE_NUMBER;
ALTER TABLE PERSON_DEGREE ADD DEGREE_ID NUMBER NOT NULL;
ALTER TABLE PERSON_DEGREE ADD PRIMARY KEY (DEGREE_ID);