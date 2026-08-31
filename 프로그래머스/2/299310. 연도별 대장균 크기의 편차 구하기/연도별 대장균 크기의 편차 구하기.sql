select year(e.differentiation_date) as "YEAR", (select max(b.size_of_colony) from ecoli_data b where year(b.differentiation_date) = year(e.differentiation_date))-e.size_of_colony as "YEAR_DEV", e.ID
from ecoli_data e
order by 1,2;