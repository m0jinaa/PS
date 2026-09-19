select e.id, case when  NTILE(4) OVER (ORDER BY e.size_of_colony DESC) = 1 then "CRITICAL" when  NTILE(4) OVER (ORDER BY e.size_of_colony DESC) = 2 then "HIGH" when  NTILE(4) OVER (ORDER BY e.size_of_colony DESC) = 3 then "MEDIUM" else "LOW" end as "COLONY_NAME"
from ECOLI_DATA e
order by e.id;