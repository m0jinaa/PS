select distinct d.id, d.email, d.first_name, d.last_name
from developers d, skillcodes s
where s.name in ("Python", "C#") and s.code & d.skill_code != 0
order by 1;