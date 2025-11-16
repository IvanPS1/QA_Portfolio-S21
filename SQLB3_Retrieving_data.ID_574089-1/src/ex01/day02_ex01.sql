SELECT all_dates::date AS missing_date
FROM generate_series('2022-01-01'::date, '2022-01-10'::date, '1 day'::interval) 
AS all_dates
LEFT JOIN (
SELECT DISTINCT visit_date 
FROM person_visits 
WHERE person_id = 1 OR person_id = 2
) AS visits ON all_dates = visits.visit_date
WHERE visits.visit_date IS NULL
ORDER BY missing_date;
