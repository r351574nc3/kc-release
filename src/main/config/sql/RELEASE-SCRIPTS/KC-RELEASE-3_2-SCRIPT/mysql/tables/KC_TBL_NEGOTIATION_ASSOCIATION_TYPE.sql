DELIMITER /
CREATE TABLE NEGOTIATION_ASSOCIATION_TYPE  ( 
	NEGOTIATION_ASSC_TYPE_ID	DECIMAL(22) NOT NULL,
	NEGOTIATION_ASSC_TYPE_CODE	    VARCHAR(3) NOT NULL,
	DESCRIPTION          	VARCHAR(30) NOT NULL,
	UPDATE_TIMESTAMP     	DATE NOT NULL,
	UPDATE_USER          	VARCHAR(60) NOT NULL,
	VER_NBR              	DECIMAL(8,0) NOT NULL,
	OBJ_ID               	VARCHAR(36) NOT NULL,
        ACTV_IND		VARCHAR(1) NOT NULL,
	CONSTRAINT NEGOTIATION_ASSC_TYPE_PK1 PRIMARY KEY(NEGOTIATION_ASSC_TYPE_ID)
) ENGINE InnoDB CHARACTER SET utf8 COLLATE utf8_bin
/
DELIMITER ;
