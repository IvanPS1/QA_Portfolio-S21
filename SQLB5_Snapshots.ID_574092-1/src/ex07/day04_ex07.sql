SELECT 
    pizzeria.name,
    menu.pizza_name
FROM pizzeria
JOIN menu ON pizzeria.id = menu.pizzeria_id 
WHERE menu.price < 800 AND pizzeria.name != 'Papa Johns';

INSERT INTO person_visits (id, person_id, pizzeria_id, visit_date)
VALUES (
    (SELECT MAX(id) FROM person_visits) + 1,
    (SELECT person.id FROM person WHERE person.name = 'Dmitriy'),
    (SELECT pizzeria.id FROM pizzeria WHERE pizzeria.name = 'Best Pizza'),
    '2022-01-08'
);

REFRESH MATERIALIZED VIEW mv_dmitriy_visits_and_eats;