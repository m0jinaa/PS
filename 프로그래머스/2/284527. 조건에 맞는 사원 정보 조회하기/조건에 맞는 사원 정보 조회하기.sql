select sum(g.score), e.emp_no, e.emp_name, e.position, e.email
from hr_grade g join hr_employees e on g.emp_no = e.emp_no
group by e.emp_no
order by 1 desc
limit 1;