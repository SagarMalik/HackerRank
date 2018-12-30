/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/

WITH TEMPTBL AS 
( Select *,  Row_NUMBER() Over (partition BY Occupation ORDER BY NAME) as RowNumber
from Occupations )
select [Doctor],[Professor], [Singer],[Actor] from TEMPTBL
PIVOT
(
MIN(Name)
for Occupation
in 
([Doctor],[Professor], [Singer],[Actor])
)

As pivottable;