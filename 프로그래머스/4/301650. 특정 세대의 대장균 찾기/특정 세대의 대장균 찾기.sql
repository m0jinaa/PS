select t.id
from ecoli_data f, ecoli_data s, ecoli_data t
where f.id = s.parent_id and s.id = t.parent_id and f.parent_id is null
order by 1;