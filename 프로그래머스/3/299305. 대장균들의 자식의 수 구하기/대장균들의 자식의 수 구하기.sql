select p.id, count(c.id) as "CHILD_COUNT"
from ecoli_data p left outer join ecoli_data c on p.id = c.parent_id
group by p.id
order by 1;