BEGIN; -- начало транзакции в Session #1
UPDATE pizzeria SET rating = 5 WHERE name = 'Pizza Hut'; -- обновление рейтинга в Session #1
SELECT * FROM pizzeria WHERE name = 'Pizza Hut'; -- проверка изменений для Session #1
SELECT * FROM pizzeria WHERE name = 'Pizza Hut'; -- проверка данных для Session #2 (до COMMIT)
COMMIT; -- сохранение изменений в Session #1
SELECT * FROM pizzeria WHERE name = 'Pizza Hut'; -- проверка данных для Session #2 (после COMMIT)