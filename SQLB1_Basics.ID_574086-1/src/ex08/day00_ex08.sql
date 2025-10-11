SELECT DISTINCT id, menu_id, order_date, person_id
FROM person_order
WHERE id % 2 = 0
ORDER BY id;
