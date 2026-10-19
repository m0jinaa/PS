select count(f.id) as "FISH_COUNT", max(f.length) as "MAX_LENGTH", f.fish_type
from fish_info f
group by f.fish_type
having avg(ifnull(f.length,10))>=33
order by 3;