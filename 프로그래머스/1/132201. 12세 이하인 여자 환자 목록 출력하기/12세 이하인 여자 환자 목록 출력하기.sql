select p.pt_name, p.pt_no, p.gend_cd, p.age, ifnull(p.tlno,"NONE")
from patient p
where p.age <= 12 and p.gend_cd = "W"
order by 4 desc, 1;