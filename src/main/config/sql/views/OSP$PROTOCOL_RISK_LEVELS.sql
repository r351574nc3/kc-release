/*
 * Copyright 2005-2013 The Kuali Foundation
 * 
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.osedu.org/licenses/ECL-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* View for Coeus compatibility */ 
CREATE OR REPLACE VIEW OSP$PROTOCOL_RISK_LEVELS AS SELECT 
	PROTOCOL_NUMBER, 
	SEQUENCE_NUMBER, 
	RISK_LEVEL_CODE, 
	COMMENTS, 
	DATE_ASSIGNED, 
	DATE_INACTIVATED "DATE_UPDATED", 
	STATUS, 
	UPDATE_USER, 
	UPDATE_TIMESTAMP
FROM PROTOCOL_RISK_LEVELS;
