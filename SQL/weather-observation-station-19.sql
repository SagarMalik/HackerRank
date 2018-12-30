/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/


select left(cast (format(POWER(POWER(max(LAT_N)-MAX(LONG_W),2.0)+POWER(min(LAT_N)-MIN(LONG_W),2.0),0.5),'#.#####') as varchar(9)),7) FROM STATION;