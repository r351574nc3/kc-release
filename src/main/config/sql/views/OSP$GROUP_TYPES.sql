-- View for Coeus compatibility 
CREATE OR REPLACE VIEW OSP$GROUP_TYPES AS SELECT 
    GROUP_TYPE_CODE, 
    GROUP_NAME, 
    UPDATE_TIMESTAMP, 
    UPDATE_USER
FROM GROUP_TYPES;
