-- 코드를 입력하세요
select floor(p.price/10000)*10000 as "PRICE_GROUP", count(p.product_id) as "PRODUCTS"
from product p
group by floor(p.price/10000)
order by 1;