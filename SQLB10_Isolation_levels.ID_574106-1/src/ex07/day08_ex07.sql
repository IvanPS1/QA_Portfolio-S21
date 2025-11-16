BEGIN; -- начало транзакции в Session #1
BEGIN; -- начало транзакции в Session #2
UPDATE pizzeria SET rating = 1.0 WHERE id = 1; -- обновление рейтинга в Session #1
UPDATE pizzeria SET rating = 2.5 WHERE id = 2; -- обновление рейтинга в Session #2
UPDATE pizzeria SET rating = 4.7 WHERE id = 2; -- обновление рейтинга в Session #1
UPDATE pizzeria SET rating = 4.4 WHERE id = 1; -- обновление рейтинга в Session #2
COMMIT; -- сохранение изменений в Session #1
COMMIT; -- сохранение изменений в Session #2