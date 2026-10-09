select f.id, f.length
from fish_info f
where f.length is not null
order by 2 desc, 1
limit 10;