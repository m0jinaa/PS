select count(u.user_id) as "USERS"
from user_info u
where year(u.joined) = 2021 and u.age between 20 and 29;