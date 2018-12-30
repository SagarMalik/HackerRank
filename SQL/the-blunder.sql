/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
Select FORMAT(CEILING (Avg(cast (salary as float))-Avg(parse(replace(cast(salary as varchar(6)),'0','')as float))), '#')  from EMPLOYEES;