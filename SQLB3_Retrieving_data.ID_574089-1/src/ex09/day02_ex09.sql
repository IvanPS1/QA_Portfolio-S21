SELECT name FROM person
WHERE gender = 'female' AND id IN (
SELECT person_id FROM person_order 
JOIN menu ON person_order.menu_id = menu.id 
WHERE menu.pizza_name = 'cheese pizza'
INTERSECT
SELECT person_id FROM person_order
JOIN menu ON person_order.menu_id = menu.id  
WHERE menu.pizza_name = 'pepperoni pizza')
ORDER BY name;