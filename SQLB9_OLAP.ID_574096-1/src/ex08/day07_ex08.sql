SELECT 
    ps.address,
    pz.name,
    COUNT(*) AS count_of_orders
FROM person_order po
JOIN person ps ON po.person_id = ps.id
JOIN menu m ON po.menu_id = m.id
JOIN pizzeria pz ON m.pizzeria_id = pz.id
GROUP BY ps.address, pz.name
ORDER BY ps.address, pz.name;