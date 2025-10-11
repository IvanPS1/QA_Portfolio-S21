SELECT order_date, 
(SELECT name || ' (age:' || age || ')' 
FROM person WHERE id = tab.person_id) AS person_information 
FROM (SELECT order_date, person_id FROM person_order) AS tab
ORDER BY order_date ASC, person_information ASC;
