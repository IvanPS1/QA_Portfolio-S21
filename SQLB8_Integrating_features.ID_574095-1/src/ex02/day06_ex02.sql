SELECT 
    person.name,
    menu.pizza_name,
    menu.price,
    ROUND(menu.price * (1 - pd.discount/100)) AS discount_price,
    pizzeria.name AS pizzeria_name
FROM person_order po
JOIN person ON po.person_id = person.id
JOIN menu ON po.menu_id = menu.id
JOIN pizzeria ON menu.pizzeria_id = pizzeria.id
JOIN person_discounts pd ON person.id = pd.person_id AND pizzeria.id = pd.pizzeria_id
ORDER BY person.name, menu.pizza_name;