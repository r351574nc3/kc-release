DELIMITER /
CREATE TABLE SEQ_PERSON_MASS_CHANGE_ID (
  id bigint(19) not null auto_increment, primary key (id)
) ENGINE MyISAM
/
ALTER TABLE SEQ_PERSON_MASS_CHANGE_ID auto_increment = 1
/
DELIMITER ;
