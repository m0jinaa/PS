SELECT 
year(s.sales_date) as "YEAR", 
month(s.sales_date) as "MONTH", 
count(distinct u.user_id) as "PURCHASED_USERS", 
round(count(distinct u.user_id)/(select count(uu.user_id) 
                                 from user_info uu 
                                 where year(uu.joined) = 2021
                                ),1) as "PURCHASED_RATIO"

from user_info u join online_sale s on u.user_id = s.user_id
where year(u.joined) = 2021
group by year(s.sales_date), month(s.sales_date)
order by 1,2;