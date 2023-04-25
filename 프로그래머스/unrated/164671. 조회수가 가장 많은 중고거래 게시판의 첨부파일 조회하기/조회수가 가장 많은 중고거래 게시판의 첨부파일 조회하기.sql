-- 코드를 입력하세요
SELECT concat('/home/grep/src/',ub.board_id,'/',uf.file_id,uf.file_name,uf.file_ext) as FILE_PATH
from used_goods_board ub, used_goods_file uf
where ub.board_id = uf.board_id
and ub.views = (select max(views) from used_goods_board)
order by uf.file_id desc;