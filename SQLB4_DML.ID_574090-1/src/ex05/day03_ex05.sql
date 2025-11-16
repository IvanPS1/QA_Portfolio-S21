SELECT pizzeria.name AS pizzeria_name
FROM pizzeria
WHERE pizzeria.id IN (
    SELECT pizzeria_id 
    FROM person_visits 
    WHERE person_id = (SELECT id FROM person WHERE name = 'Andrey')
    
    EXCEPT
    
    SELECT menu.pizzeria_id
    FROM person_order
    JOIN menu ON person_order.menu_id = menu.id
    WHERE person_order.person_id = (SELECT id FROM person WHERE name = 'Andrey'))
ORDER BY pizzeria_name;