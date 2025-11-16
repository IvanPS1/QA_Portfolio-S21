WITH gender_visits AS (
    SELECT 
        pizzeria.name AS pizzeria_name,
        person.gender,
        COUNT(*) AS visit_count
    FROM person_visits
    JOIN person ON person_visits.person_id = person.id
    JOIN pizzeria ON person_visits.pizzeria_id = pizzeria.id
    GROUP BY pizzeria.name, person.gender
),
gender_comparison AS (
    SELECT 
        female_visits.pizzeria_name
    FROM gender_visits AS female_visits
    JOIN gender_visits AS male_visits ON female_visits.pizzeria_name = male_visits.pizzeria_name 
    WHERE female_visits.gender = 'female' 
      AND male_visits.gender = 'male'
      AND female_visits.visit_count > male_visits.visit_count
    UNION ALL
    SELECT 
        male_visits.pizzeria_name
    FROM gender_visits AS male_visits
    JOIN gender_visits AS female_visits ON male_visits.pizzeria_name = female_visits.pizzeria_name 
    WHERE male_visits.gender = 'male' 
      AND female_visits.gender = 'female'
      AND male_visits.visit_count > female_visits.visit_count
)
SELECT pizzeria_name
FROM gender_comparison
ORDER BY pizzeria_name;