# Write your MySQL query statement below
with tab1 as(
    select dense_rank() over (order by score desc) as rnk, score as score from scores
)

select score,rnk as "rank" from tab1;