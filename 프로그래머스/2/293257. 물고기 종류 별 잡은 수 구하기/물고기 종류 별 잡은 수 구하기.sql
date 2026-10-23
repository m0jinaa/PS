select count(f.id) as "FISH_COUNT", fn.fish_name
from fish_info f join fish_name_info fn on f.fish_type = fn.fish_type
group by f.fish_type
order by 1 desc;