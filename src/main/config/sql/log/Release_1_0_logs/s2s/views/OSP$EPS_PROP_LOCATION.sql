create or replace view OSP$EPS_PROP_LOCATION as 
	select PROPOSAL_NUMBER,LOCATION,ROLODEX_ID,UPDATE_TIMESTAMP,UPDATE_USER
	from EPS_PROP_LOCATION;