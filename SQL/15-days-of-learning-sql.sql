/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
Submissions: The submission_date is the date of the submission, submission_id is the id of the submission, hacker_id is the id of the hacker who made the submission, and score is the score of the submission.
*/
with tabledhsummary as 
(Select submission_date as sdate , hacker_id as id , count(*) as scount from submissions group by submission_date,hacker_id),
tbldsummary as (
select sdate , max(scount) as maxcount from tabledhsummary group by sdate
),
 tabledhsummary2 as 
(
Select tabledhsummary.sdate as sdate, min(tabledhsummary.id) as id from tabledhsummary inner join tbldsummary on
    tabledhsummary.sdate=tbldsummary.sdate
    where 
    tabledhsummary.scount=tbldsummary.maxcount
    group by tabledhsummary.sdate
 ),
tablecountsummary as 
(
select t1.sdate, count(t1.id) as totalcount from tabledhsummary t1
    where datediff(DAY, '2016-03-01',t1.sdate)<=( Select count(*) from tabledhsummary t3  where t3.sdate >= '2016-03-01' and t3.sdate < t1.sdate and t3.id=t1.id)
    group by sdate
)
 Select tablecountsummary.sdate,tablecountsummary.totalcount, tabledhsummary2.id , hackers.name from tablecountsummary,tabledhsummary2,hackers
where tablecountsummary.sdate=tabledhsummary2.sdate
and tabledhsummary2.id=hackers.hacker_id order by tablecountsummary.sdate;