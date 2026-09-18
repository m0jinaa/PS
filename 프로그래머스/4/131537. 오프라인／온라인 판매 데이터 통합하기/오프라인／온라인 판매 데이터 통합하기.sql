 select sales_date, product_id, user_id, sales_amount from ((SELECT o.sales_date as "sales_date", o.product_id as "product_id", o.user_id as "user_id", o.sales_amount as "sales_amount"
from online_sale o
where year(o.sales_date) = 2022 and month(o.sales_date) = 3)
union all
(select f.sales_date, f.product_id, null, f.sales_amount
from offline_sale f
where year(f.sales_date) = 2022 and month(f.sales_date) = 3)) t
order by 1 ,2, 3;