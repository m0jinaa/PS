select count(f.id) as "FISH_COUNT", month(f.time) as "MONTH"
from fish_info f
group by month(f.time)
order by 2;