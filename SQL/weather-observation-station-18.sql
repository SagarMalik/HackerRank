/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
select format (ABS(max(LAT_N)-max(LONG_W))+ABS(min(LAT_N)-min(LONG_W)),'#.####') from station