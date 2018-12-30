/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
Projects, containing three columns: Task_ID, Start_Date and End_Date
*/
WIth TBL as (
Select p1.Start_Date as prevStart, p1.End_Date as PrevEnd,P2.Start_Date as StartDate from Projects p2 full outer join Projects p1 
on p2.Start_Date=P1.End_Date
)
,tbl2 as ( Select t1.startDate as StartDate, CASE WHEN  (Select  Min(t2.PrevEnd)  from tbl t2 where t2.prevStart>t1.startDate and t2.startDate is NULL) IS NOT NULL THEN
 (Select  Min(t2.PrevEnd)  from tbl t2 where datediff(DAY,t1.startDate,t2.prevStart)>-1 and t2.startDate is NULL) ELSE (SELECT  Max(t3.prevEnd) FROM tbl t3) END as endDate from tbl t1
where t1.PrevEnd is NULL 
             )
Select t4.startDate, t4.EndDate from tbl2 t4 order by datediff(Day,t4.startDate,t4.EndDate),t4.startDate;