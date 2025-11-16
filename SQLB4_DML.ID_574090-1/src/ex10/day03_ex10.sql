INSERT INTO person_order (id, person_id, menu_id, order_date)
VALUES (
    (SELECT MAX(id) FROM person_order) + 1,
    (SELECT person.id FROM person WHERE person.name = 'Denis'),
    (SELECT menu.id FROM menu WHERE menu.pizza_name = 'Sicilian pizza'),
    '2022-02-24'
);

INSERT INTO person_order (id, person_id, menu_id, order_date)
VALUES (
    (SELECT MAX(id) FROM person_order) + 1,
    (SELECT person.id FROM person WHERE person.name = 'Irina'),
    (SELECT menu.id FROM menu WHERE menu.pizza_name = 'Sicilian pizza'),
    '2022-02-24'
);