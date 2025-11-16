BEGIN; -- начало транзакции в Session #1
BEGIN; -- начало транзакции в Session #2
SELECT SUM(rating) AS rating_sum FROM pizzeria; -- проверка суммы рейтингов для Session #1
INSERT INTO pizzeria (id, name, rating) VALUES (10, 'Kazan Pizza', 5); -- обновление рейтинга в Session #2
COMMIT; -- сохранение изменений в Session #2
SELECT SUM(rating) AS rating_sum FROM pizzeria; -- проверка суммы рейтингов для Session #1
COMMIT; -- сохранение изменений в Session #1
SELECT SUM(rating) AS rating_sum FROM pizzeria; -- проверка суммы рейтингов для Session #1
SELECT SUM(rating) AS rating_sum FROM pizzeria; -- проверка суммы рейтингов для Session #2