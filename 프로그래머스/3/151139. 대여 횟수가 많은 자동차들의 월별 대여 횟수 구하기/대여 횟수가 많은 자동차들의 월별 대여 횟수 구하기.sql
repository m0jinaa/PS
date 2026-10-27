select month(r.start_date) as "MONTH", r.car_id, count(r.history_id)
from car_rental_company_rental_history r
where year(r.start_date) = 2022 and month(r.start_date) between 8 and 10
and r.car_id in (
    select rr.car_id
    from car_rental_company_rental_history rr
    where year(rr.start_date) = 2022 and month(rr.start_date) between 8 and 10
    group by rr.car_id
    having count(rr.history_id)>=5
)
group by r.car_id, month(r.start_date)
order by 1,2 desc