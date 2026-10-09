select d.id, d.email, d.first_name, d.last_name
from developer_infos d
where d.skill_1 = "Python" or d.skill_2 = "Python" or d.skill_3 = "Python"
order by 1;