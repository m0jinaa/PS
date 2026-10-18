select e.emp_no, e.emp_name, g.grade, e.sal * (case when g.grade = "S" then 0.2 when g.grade = "A" then 0.15 when g.grade = "B" then 0.1 else 0 end) as "BONUS"
from hr_employees e join (select h.emp_no, case when avg(h.score)>=96 then "S" when avg(h.score)>=90 then "A" when avg(h.score)>=80 then "B" else "C" end as "grade"
from hr_grade h
group by h.emp_no) g on e.emp_no = g.emp_no
order by 1;
