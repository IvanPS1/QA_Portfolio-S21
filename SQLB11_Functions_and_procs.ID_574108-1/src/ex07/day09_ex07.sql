CREATE FUNCTION func_minimum(VARIADIC arr numeric[])
RETURNS numeric AS $$
    SELECT MIN(element) 
    FROM unnest(arr) AS element;
$$ LANGUAGE SQL;