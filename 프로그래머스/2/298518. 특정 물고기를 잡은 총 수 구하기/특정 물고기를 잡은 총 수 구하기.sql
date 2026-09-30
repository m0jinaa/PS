select count(fi.id) as "FISH_COUNT"
from fish_info fi, fish_name_info fn
where fi.fish_type = fn.fish_type and fn.fish_name in ("BASS","SNAPPER");