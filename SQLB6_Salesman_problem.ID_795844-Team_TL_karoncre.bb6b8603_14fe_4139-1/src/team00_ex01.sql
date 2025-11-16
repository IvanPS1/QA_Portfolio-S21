WITH RECURSIVE tour_point AS (
    SELECT t.point1, 
       point2, 
	   t.point1 || ',' || t.point2 AS tour, 
	   t.cost AS total_cost
    FROM tour t
    WHERE point1 = 'a'
    UNION ALL
    SELECT tp.point1, 
       t.point2, 
	   tp.tour || ',' || t.point2, 
	   tp.total_cost + t.cost 
    FROM tour t
    INNER JOIN tour_point tp ON tp.point2 = t.point1
    WHERE position(t.point2 in tp.tour) = 0
),

full_tours AS (
SELECT total_cost + (
    SELECT cost 
    FROM tour
    WHERE point1 = tour_point.point2 
    AND point2 = 'a') AS total_cost,
	'{' || tour || ',a}' AS tour
FROM tour_point
WHERE length(tour) = 7 AND point1 = 'a') 

SELECT total_cost, tour
FROM full_tours
ORDER BY total_cost, tour;