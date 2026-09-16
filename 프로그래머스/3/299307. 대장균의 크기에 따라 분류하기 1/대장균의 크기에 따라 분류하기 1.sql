select e.id, case when e.size_of_colony <=100 then "LOW" when e.size_of_colony <=1000 then "MEDIUM" else "HIGH" end as "SIZE"
from ECOLI_DATA e
order by 1 asc;