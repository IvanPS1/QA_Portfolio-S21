BEGIN; -- начало транзакции в Session #1
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ; -- установка уровня изоляции REPEATABLE READ для Session #1
BEGIN; -- начало транзакции в Session #2
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ; -- установка уровня изоляции REPEATABLE READ для Session #2
SELECT SUM(rating) AS rating_sum FROM pizzeria; -- проверка суммы рейтингов для Session #1
INSERT INTO pizzeria (id, name, rating) VALUES (11, 'Kazan Pizza 2', 4); -- обновление рейтинга в Session #2
COMMIT; -- сохранение изменений в Session #2
SELECT SUM(rating) AS rating_sum FROM pizzeria; -- проверка суммы рейтингов для Session #1
COMMIT; -- сохранение изменений в Session #1
SELECT SUM(rating) AS rating_sum FROM pizzeria; -- проверка суммы рейтингов для Session #1
SELECT SUM(rating) AS rating_sum FROM pizzeria; -- проверка суммы рейтингов для Session #2