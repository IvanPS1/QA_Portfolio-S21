SELECT name 
FROM person p
WHERE EXISTS 
(SELECT 1 FROM person_order 
WHERE person_id = p.id)
ORDER BY name;