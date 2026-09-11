SELECT b.book_id, a.author_name, b.published_date
from Author a, Book b
where a.author_id = b.author_id and b.category = "경제"
order by b.published_date asc;