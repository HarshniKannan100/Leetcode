# Write your MySQL query statement below
with tab1 as(
    select p.product_id,p.price*u.units as average_rate, u.units from prices p left join unitssold u on p.product_id=u.product_id and u.purchase_date between p.start_date and p.end_date
)

select product_id,if(sum(average_rate) is null,0,round(sum(average_rate)/sum(units),2)) as average_price from tab1 group by product_id;