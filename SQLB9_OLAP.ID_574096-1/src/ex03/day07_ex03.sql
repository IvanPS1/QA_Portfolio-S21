SELECT 
    COALESCE(visits.name, orders.name) AS name,
    COALESCE(visits.visit_count, 0) + COALESCE(orders.order_count, 0) AS total_count
FROM 
    (SELECT 
        pz.name, 
        COUNT(*) AS visit_count
     FROM person_visits pv
     JOIN pizzeria pz ON pv.pizzeria_id = pz.id
     GROUP BY pz.name) AS visits
FULL JOIN 
    (SELECT 
        pz.name, 
        COUNT(*) AS order_count
     FROM person_order po
     JOIN menu m ON po.menu_id = m.id
     JOIN pizzeria pz ON m.pizzeria_id = pz.id
     GROUP BY pz.name) AS orders
    ON visits.name = orders.name
ORDER BY total_count DESC;