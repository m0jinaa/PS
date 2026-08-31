-- 코드를 입력하세요
SELECT t.flavor
from ((select * from first_half) union all (select * from july)) t
group by t.flavor
order by sum(t.total_order) desc
limit 3;