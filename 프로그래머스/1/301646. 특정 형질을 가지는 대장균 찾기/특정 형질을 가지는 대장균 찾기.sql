select count(e.id) as "COUNT"
from ecoli_data e
where (e.genotype & 5) != 0 and (e.genotype & 2) = 0;