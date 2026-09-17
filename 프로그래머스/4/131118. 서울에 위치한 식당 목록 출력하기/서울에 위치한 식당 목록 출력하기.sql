SELECT i.rest_id, i.rest_name, i.food_type, i.favorites, i.address, ifnull(round(avg(r.review_score),2),0) as "SCORE"
from rest_info i, rest_review r
where i.rest_id = r.rest_id and i.address like "서울%"
group by i.rest_id
order by 6 desc, 4 desc;