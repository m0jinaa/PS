select s.route, concat(round(sum(s.d_between_dist),1),"km") as "TOTAL_DISTANCE", concat(round(avg(s.d_between_dist),2),"km") as "AVERAGE_DISTANCE"
from subway_distance s
group by s.route
order by round(sum(s.d_between_dist),1) desc;