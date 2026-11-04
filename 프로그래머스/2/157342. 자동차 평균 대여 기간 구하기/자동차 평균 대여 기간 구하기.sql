select h.car_id, round(avg(datediff(h.end_date,h.start_date)+1),1) as "AVERAGE_DURATION"
from car_rental_company_rental_history h
group by h.car_id
having round(avg(datediff(h.end_date,h.start_date)+1),1) >= 7
order by 2 desc, 1 desc;