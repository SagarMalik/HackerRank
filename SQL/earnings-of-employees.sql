/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
select top 1 max(totalsalary), count(totalsalary) from (select salary*months as totalsalary from employee) employees group by totalsalary order by totalsalary desc;