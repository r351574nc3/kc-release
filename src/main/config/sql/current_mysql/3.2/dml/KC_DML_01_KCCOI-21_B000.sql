DELIMITER /
INSERT INTO COI_DISCLOSURE_STATUS (COI_DISCLOSURE_STATUS_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID)
VALUES('203', 'Closed', NOW(), 'admin', UUID())
/
INSERT INTO COI_DISCLOSURE_STATUS (COI_DISCLOSURE_STATUS_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID)
VALUES('202', 'Void - Disclosure not rquired', NOW(), 'admin', UUID())
/
INSERT INTO COI_DISCLOSURE_STATUS (COI_DISCLOSURE_STATUS_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID)
VALUES('100', 'Pending', NOW(), 'admin', UUID())
/
INSERT INTO COI_DISCLOSURE_STATUS (COI_DISCLOSURE_STATUS_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID)
VALUES('101', 'PI Reviewed', NOW(), 'admin', UUID())
/
INSERT INTO COI_DISCLOSURE_STATUS (COI_DISCLOSURE_STATUS_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID)
VALUES('102', 'OSP-Review in Progress', NOW(), 'admin', UUID())
/
INSERT INTO COI_DISCLOSURE_STATUS (COI_DISCLOSURE_STATUS_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID)
VALUES('103', 'Other Review in Progress', NOW(), 'admin', UUID())
/
INSERT INTO COI_DISCLOSURE_STATUS (COI_DISCLOSURE_STATUS_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID)
VALUES('200', 'No Conflict', NOW(), 'admin', UUID())
/
INSERT INTO COI_DISCLOSURE_STATUS (COI_DISCLOSURE_STATUS_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID)
VALUES('201', 'Resolved', NOW(), 'admin', UUID())
/
INSERT INTO COI_DISCLOSURE_STATUS (COI_DISCLOSURE_STATUS_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID)
VALUES('300', 'Unresolved', NOW(), 'admin', UUID())
/
INSERT INTO COI_DISCLOSURE_STATUS (COI_DISCLOSURE_STATUS_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID)
VALUES('104', 'Pending Annual Disclosure', NOW(), 'admin', UUID())
/
INSERT INTO COI_DISCLOSURE_STATUS (COI_DISCLOSURE_STATUS_CODE, DESCRIPTION, UPDATE_TIMESTAMP, UPDATE_USER, OBJ_ID)
VALUES('204', 'Superseded by Award', NOW(), 'admin', UUID())
/
DELIMITER ;
