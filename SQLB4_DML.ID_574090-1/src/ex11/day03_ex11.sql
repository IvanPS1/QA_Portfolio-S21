UPDATE menu
SET price = (price * 0.9)::integer
WHERE pizza_name = 'Greek pizza';