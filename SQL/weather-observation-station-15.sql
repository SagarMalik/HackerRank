/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
select format(LONG_W,'#.####') from station where LAT_N = (select max(LAT_N) from station where LAT_N < 137.2345);