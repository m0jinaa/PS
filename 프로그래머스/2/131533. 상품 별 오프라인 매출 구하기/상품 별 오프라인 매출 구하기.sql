-- 코드를 입력하세요
SELECT p.product_code, sum(p.price * o.sales_amount) as "sales"
from Product p, Offline_sale o
where p.product_id = o.product_id
group by p.product_code
order by 2 desc, 1 asc;