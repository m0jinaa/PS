select year(p.ym) as "YEAR", round(avg(p.pm_val1),2) as "PM10",round(avg(p.pm_val2),2) as "PM2.5"
from air_pollution p
where p.location2 = "수원"
group by year(p.ym)
order by 1;