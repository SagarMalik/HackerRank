/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
select sum(ci.Population) from City ci inner join country co on ci.Countrycode=co.code and co.continent='Asia';