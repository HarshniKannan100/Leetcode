# Write your MySQL query statement below
with tab1 as(
    select count(t.id) as cnt, t.request_at from trips t where t.client_id in (select users_id from users where banned='No') and t.driver_id in (select users_id from users where banned='No') group by t.request_at
),tab2 as(
    select count(t.id) as cnt, t.request_at from trips t where t.client_id in (select users_id from users where banned='No') and t.driver_id in (select users_id from users where banned='No') and status!='completed' group by t.request_at  
),tab3 as(
    select distinct trips.request_at,case when trips.request_at not in (select request_at from tab2) then 0 else tab2.cnt end as cnt from trips left join tab2 on trips.request_at=tab2.request_at where right(trips.request_at,2)>0 and right(trips.request_at,2)<4
)
select tab1.request_at as Day, round(tab3.cnt/tab1.cnt,2) as 'Cancellation Rate' from tab1 join tab3 on tab1.request_at=tab3.request_at;