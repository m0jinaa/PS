select u.user_id, u.nickname, sum(b.price) as "TOTAL_SALES"
from used_goods_user u join used_goods_board b on u.user_id = b.writer_id
where b.status = "DONE"
group by u.user_id
having sum(b.price)>=700000
order by 3;