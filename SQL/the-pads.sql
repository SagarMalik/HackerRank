/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
Select concat(Name,'('+Left(Occupation,1) +')') from OCCUPATIONS order by Name;
Select 'There are total '+ cast(count(*) as varchar(1))+ ' '+Lower(min(Occupation)) +   's.'  from Occupations group by Occupation order by count(*);