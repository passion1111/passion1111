SELECT * 
    FROM user_objects
    WHERE LOWER(object_type)='procedure';
    
SELECT text 
    FROM user_source
    WHERE LOWER(NAME) = 'p_test';