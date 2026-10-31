-- 코드를 입력하세요
SELECT f.order_id, f.product_id, f.out_date, case when f.out_date is null then "출고미정" when f.out_date <="2022-05-01" then "출고완료" else "출고대기" end as "출고여부"
from food_order f
order by 1;