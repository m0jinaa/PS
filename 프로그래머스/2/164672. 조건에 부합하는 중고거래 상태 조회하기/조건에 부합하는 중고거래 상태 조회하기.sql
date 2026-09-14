-- 코드를 입력하세요
SELECT b.board_id, b.writer_id, b.title, b.price, case b.status when "DONE" then"거래완료" when "RESERVED" then "예약중" else "판매중" end as "STATUS"
from USED_GOODS_BOARD b
where b.created_date = "2022-10-05"
order by b.board_id desc;