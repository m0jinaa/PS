select c.id, c.genotype, p.genotype as "PARENT_GENOTYPE"
from ecoli_data c , ecoli_data p 
where c.parent_id = p.id
and (c.genotype & p.genotype) = p.genotype
order by 1;