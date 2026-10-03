select r.food_type, r.rest_id, r.rest_name, r.favorites
from rest_info r
where r.favorites = (select max(rr.favorites) from rest_info rr where rr.food_type = r.food_type)
order by 1 desc;