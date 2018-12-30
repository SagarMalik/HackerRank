/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
Samantha interviews many candidates from different colleges using coding challenges and contests. Write a query to print the contest_id, hacker_id, name, and the sums of total_submissions, total_accepted_submissions, total_views, and total_unique_views for each contest sorted by contest_id. Exclude the contest from the result if all four sums are 0.

Contests: The contest_id is the id of the contest, hacker_id is the id of the hacker who created the contest, and name is the name of the hacker.

Colleges: The college_id is the id of the college, and contest_id is the id of the contest that Samantha used to screen the candidates.

Challenges: The challenge_id is the id of the challenge that belongs to one of the contests whose contest_id Samantha forgot, and college_id is the id of the college where the challenge was given to candidates.

View_Stats: The challenge_id is the id of the challenge, total_views is the number of times the challenge was viewed by candidates, and total_unique_views is the number of times the challenge was viewed by unique candidates.

Submission_Stats: The challenge_id is the id of the challenge, total_submission is the number of submissions for the challenge, and total_accepted_submission is the number of submissions that achieved full scores.

A specific contest can be used to screen candidates at more than one college, but each college only holds 1 screening contest.
*/

with collegeview as (
Select contests.contest_id as contestid, contests.hacker_id as hid, contests.name as hname , colleges.college_id as collegeid from contests inner join colleges on contests.contest_id=colleges.contest_id
)
,Submission_Stats1 as 
(
Select challenge_id, sum(total_submissions) as total_submissions , sum(total_accepted_submissions) as total_accepted_submissions from Submission_stats group by challenge_id
),View_Stats1 as 
(
Select challenge_id, sum(total_views) as total_views , sum(total_unique_views) as total_unique_views from View_Stats group by challenge_id
)
, statsview as 
(
Select COALESCE(vs.challenge_id,ss.challenge_id) as challengeid,vs.total_views as totalview ,vs.total_unique_views as UniqueView , ss.total_submissions as totalsubmission , ss.total_accepted_submissions as acceptedsubmission from  View_Stats1 vs Full Outer join Submission_Stats1 ss on vs.challenge_id=ss.challenge_id
)
,
bigview as 
(
    select cv.contestid as contestid,min(cv.hid) as hackerid,min(cv.hname) as hackername,sum(sv.totalview) as totalviews, sum(sv.uniqueview) as uniqueviews, sum(sv.totalsubmission) as totalsubmissions,sum(sv.acceptedsubmission) as acceptedsubmissions
    from statsview sv, collegeview cv , Challenges c
    where c.challenge_id=sv.challengeid and c.college_id=cv.collegeid
  group by cv.contestid
)
select contestid,hackerid,hackername,totalsubmissions,acceptedsubmissions,totalviews,uniqueviews from bigview
where (totalviews is not null and totalviews!=0) or (uniqueviews is not null and uniqueviews!=0) or (totalsubmissions is not null and totalsubmissions!=0) or (acceptedsubmissions is not null and acceptedsubmissions!=0)
order by contestid