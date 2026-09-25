select round(avg(ifnull(f.length,10)),2) as "AVERAGE_LENGTH"
from FISH_INFO f;