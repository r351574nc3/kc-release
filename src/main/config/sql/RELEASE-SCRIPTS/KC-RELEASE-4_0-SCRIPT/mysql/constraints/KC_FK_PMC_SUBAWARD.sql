DELIMITER /
ALTER TABLE PMC_SUBAWARD
  ADD CONSTRAINT FK_PMC_SUBAWARD_ID
  FOREIGN KEY (PERSON_MASS_CHANGE_ID) REFERENCES PERSON_MASS_CHANGE (PERSON_MASS_CHANGE_ID)
/
DELIMITER ;
