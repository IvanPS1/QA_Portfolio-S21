COMMENT ON TABLE person_discounts IS 'A table for storing personal discounts for customers in pizzerias';
COMMENT ON COLUMN person_discounts.person_id IS 'Client ID';
COMMENT ON COLUMN person_discounts.pizzeria_id IS 'Pizzeria ID';
COMMENT ON COLUMN person_discounts.discount IS 'Discount amount in percentage';