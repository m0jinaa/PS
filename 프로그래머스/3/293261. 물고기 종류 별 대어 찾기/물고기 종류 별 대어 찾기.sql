select fi.id, fn.fish_name, fi.length
from fish_info fi join fish_name_info fn on fn.fish_type = fi.fish_type
where fi.length = (select max(f.length) from fish_info f where f.fish_type = fi.fish_type)
order by fi.id;