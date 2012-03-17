delete from UNIT_ADMINISTRATOR;
delete from UNIT_ADMINISTRATOR_TYPE;

Insert into unit_administrator_type
(UNIT_ADMINISTRATOR_TYPE_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, DEFAULT_GROUP_FLAG, MULTIPLES_FLAG)
Values ('1', 'ADMINISTRATIVE_OFFICER',  sysdate, user, 'C', 'N');
Insert into unit_administrator_type
(UNIT_ADMINISTRATOR_TYPE_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, DEFAULT_GROUP_FLAG, MULTIPLES_FLAG)
Values ('2', 'OSP_ADMINISTRATOR',  sysdate, user, 'C', 'Y');
Insert into unit_administrator_type
(UNIT_ADMINISTRATOR_TYPE_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, DEFAULT_GROUP_FLAG, MULTIPLES_FLAG)
Values ('3', 'UNIT_HEAD',  sysdate, user, 'U', 'N');
Insert into unit_administrator_type
(UNIT_ADMINISTRATOR_TYPE_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, DEFAULT_GROUP_FLAG, MULTIPLES_FLAG)
Values ('4', 'DEAN_VP',  sysdate, user, 'U', 'N');
Insert into unit_administrator_type
(UNIT_ADMINISTRATOR_TYPE_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, DEFAULT_GROUP_FLAG, MULTIPLES_FLAG)
Values ('5', 'OTHER_INDIVIDUAL_TO_NOTIFY',  sysdate, user, 'U', 'Y');
Insert into unit_administrator_type
(UNIT_ADMINISTRATOR_TYPE_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, DEFAULT_GROUP_FLAG, MULTIPLES_FLAG)
Values ('6', 'AOR-Authorized Organizational Representative',  sysdate, user, 'N', 'N');
Insert into unit_administrator_type
(UNIT_ADMINISTRATOR_TYPE_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, DEFAULT_GROUP_FLAG, MULTIPLES_FLAG)
Values ('7', 'Administrative Contact',  sysdate, user, 'U', 'Y');
Insert into unit_administrator_type
(UNIT_ADMINISTRATOR_TYPE_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, DEFAULT_GROUP_FLAG, MULTIPLES_FLAG)
Values ('8', 'Financial Contact',  sysdate, user, 'U', 'N');

Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('000001', '10000000001', 1, sysdate, user);
 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('000001', '10000000001', 2, sysdate, user);
Insert into unit_administrator
 (UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('000001', '10000000035', 2, sysdate, user);
 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('000001', '10000000001', 3, sysdate, user);
 
 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('IN-CARD', '10000000001', 3, sysdate, user);
 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('IN-CARD', '10000000022', 1, sysdate, user);

 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('BL-BL', '10000000002', 2, sysdate, user);
 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('BL-BL', '10000000028', 5, sysdate, user);
 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('BL-BL', '10000000030', 7, sysdate, user);

 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('BL-IIDC', '10000000036', 2, sysdate, user);
 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('BL-IIDC', '10000000037', 5, sysdate, user);
 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('BL-IIDC', '10000000038', 7, sysdate, user);

 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('BL-RCEN', '10000000001', 1, sysdate, user);
 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('BL-RCEN', '10000000018', 2, sysdate, user);
Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('BL-RCEN', '10000000041', 2, sysdate, user);
 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('BL-RCEN', '10000000021', 7, sysdate, user);

 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('IN-CARR', '10000000007', 1, sysdate, user);
 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('IN-CARR', '10000000034', 8, sysdate, user);
 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('IN-CARR', '10000000045', 5, sysdate, user);

 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('IN-MDEP', '10000000005', 1, sysdate, user);
 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('IN-MDEP', '10000000041', 2, sysdate, user);
 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('IN-MDEP', '10000000042', 3, sysdate, user);

 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)  
 Values ('IN-PERS', '10000000050', 1, sysdate, user);
 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('IN-PERS', '10000000051', 2, sysdate, user);
 Insert into unit_administrator
(UNIT_NUMBER, PERSON_ID, UNIT_ADMINISTRATOR_TYPE_CODE, UPDATE_TIMESTAMP, UPDATE_USER)
 Values ('IN-PERS', '10000000052', 8, sysdate, user);



