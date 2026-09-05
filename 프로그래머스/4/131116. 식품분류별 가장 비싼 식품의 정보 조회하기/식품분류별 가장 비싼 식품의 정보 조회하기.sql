-- 코드를 입력하세요
SELECT f.category, f.price as "max_price", f.product_name
from food_product f
where f.category in ("식용유","과자","국","김치")
and f.price = (select max(fp.price)
              from food_product fp
              where fp.category = f.category)
order by 2 desc;