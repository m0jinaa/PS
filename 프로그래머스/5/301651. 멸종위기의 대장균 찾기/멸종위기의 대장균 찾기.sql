with recursive ecoli as (

    select id, 1 as "generation" 
    from ecoli_data
    where parent_id is null

    union all 

    select c.id, 1+p.generation as "generation"
    from ecoli_data c inner join ecoli p 
    on c.parent_id = p.id
)


select count(e.id) as "COUNT", e.generation
from 
    ecoli e 
    left outer join 
    (select a.parent_id, count(a.id) as "child_count" 
     from ecoli_data a 
     group by a.parent_id) f
    on e.id = f.parent_id
where f.parent_id is null
group by e.generation
order by 2;