BEGIN; -- начало транзакции в Session #1
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE; -- установка уровня изоляции SERIALIZABLE для Session #1
BEGIN; -- начало транзакции в Session #2
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE; -- установка уровня изоляции SERIALIZABLE для Session #2
SELECT * FROM pizzeria WHERE name = 'Pizza Hut'; -- проверка данных для Session #1
UPDATE pizzeria SET rating = 3.6 WHERE name = 'Pizza Hut'; -- обновление рейтинга в Session #2
COMMIT; -- сохранение изменений в Session #2
SELECT * FROM pizzeria WHERE name = 'Pizza Hut'; -- проверка изменений для Session #1
COMMIT; -- сохранение изменений в Session #1
SELECT * FROM pizzeria WHERE name = 'Pizza Hut'; -- проверка изменений для Session #1
SELECT * FROM pizzeria WHERE name = 'Pizza Hut'; -- проверка изменений для Session #2