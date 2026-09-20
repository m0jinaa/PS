select a.mcdp_cd as "진료과코드", count(a.apnt_ymd) as "5월예약건수"
from appointment a
where year(a.apnt_ymd) = 2022 and month(a.apnt_ymd) = 5
group by a.mcdp_cd
order by 2,1;