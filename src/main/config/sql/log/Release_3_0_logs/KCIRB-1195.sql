ALTER TABLE "AFFILIATION_TYPE"
	ADD ( "ACTIVE_FLAG" CHAR(1) NULL ) 
/
update affiliation_type
set active_flag = 'Y'
/
commit
/
ALTER TABLE "AFFILIATION_TYPE" MODIFY ( "ACTIVE_FLAG" CHAR(1) NOT NULL )
/