SELECT p.product_id, p.product_name, sum(o.amount)*p.price as "total_sales"
from food_product p, food_order o
where p.product_id = o.product_id and year(o.produce_date) = 2022 and month(o.produce_date) = 5
group by p.product_id
order by 3 desc, 1 asc;