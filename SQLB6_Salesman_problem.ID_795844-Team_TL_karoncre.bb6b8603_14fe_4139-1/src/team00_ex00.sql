WITH RECURSIVE tours AS (
    SELECT 
        point1,
        point2,
        cost,
        cost AS total_cost,
        ARRAY[point1, point2] AS path,
        1 AS depth
    FROM tour
    WHERE point1 = 'a'
    
    UNION ALL 
    
    SELECT 
        tours.point1,
        tour.point2,
        tour.cost,
        tours.total_cost + tour.cost AS total_cost,
        tours.path || tour.point2 AS path,
        tours.depth + 1
    FROM tours
    JOIN tour ON tours.point2 = tour.point1
    WHERE 
        (tour.point2 <> ALL(tours.path) OR (tours.depth = 3 AND tour.point2 = 'a'))
        AND tours.depth < 4
),
complete_tours AS (
    SELECT 
        total_cost,
        '{' || array_to_string(path, ',') || '}' AS tour
    FROM tours
    WHERE depth = 4 AND path[1] = 'a' AND path[5] = 'a'
)
SELECT 
    total_cost,
    tour
FROM complete_tours
WHERE total_cost = (SELECT MIN(total_cost) FROM complete_tours)
ORDER BY total_cost, tour;