-- 코드를 입력하세요
SELECT m.member_id, m.member_name, m.gender, m.date_of_birth
from member_profile m
where month(m.date_of_birth) = 3 and m.gender = 'W'
and m.tlno is not null
order by 1 asc;
