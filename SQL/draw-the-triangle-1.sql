/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
DECLARE @cnt INT = 20;

WHILE @cnt > 0
BEGIN
 SELECT REPLICATE('* ', (@cnt))
 SET @cnt = @cnt - 1;
END;