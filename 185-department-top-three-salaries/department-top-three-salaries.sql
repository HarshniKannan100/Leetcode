# Write your MySQL query statement below
with tab1 as(
    select dense_rank() over (partition by departmentId order by salary desc) as rnk,departmentId, salary ,id ,name from employee
)

select d.name as Department, e.name as Employee , e.salary as Salary from employee e join department d on e.departmentId=d.id join tab1 on tab1.id=e.id where tab1.rnk<=3;