ALTER TABLE PMC_IACUC_PROTOCOL
  ADD CONSTRAINT FK_PMC_IACUC_PROTOCOL_ID
  FOREIGN KEY (PERSON_MASS_CHANGE_ID) REFERENCES PERSON_MASS_CHANGE (PERSON_MASS_CHANGE_ID)
/
