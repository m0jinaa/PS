select count(f.id) as "FISH_COUNT"
from fish_info f
where f.length is null;