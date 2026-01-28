# Write your MySQL query statement below
select p.product_name, year, price from Sales left join Product p on Sales.product_id=p.product_id; 