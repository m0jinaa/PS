select d.dr_name, d.dr_id, d.mcdp_cd, d.hire_ymd
from doctor d
where d.mcdp_cd in ("CS","GS")
order by 4 desc, 1;