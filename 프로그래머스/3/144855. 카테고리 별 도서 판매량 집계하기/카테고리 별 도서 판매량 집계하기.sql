select b.category, sum(s.sales) as "TOTAL_SALES"
from Book b join Book_Sales s on b.book_id = s.book_id
where year(s.sales_date) = 2022 and month(s.sales_date) = 1
group by b.category
order by 1;