-- 코드를 입력하세요
SELECT a.author_id, a.author_name, b.category, sum(b.price * bs.sales) as "total_sales"
from BOOK b, AUTHOR a, BOOK_SALES bs
where b.author_id = a.author_id and b.book_id = bs.book_id
and year(bs.sales_date) = 2022 and month(bs.sales_date) = 1
group by a.author_id,b.category
order by a.author_id, b.category desc;