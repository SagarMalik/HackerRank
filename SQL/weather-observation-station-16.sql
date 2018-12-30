/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
select format(min(LAT_N),'#.####') from station where LAT_N > 38.7780;