/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
DECLARE @cnt INT = 1;

WHILE @cnt < 21
BEGIN
 SELECT REPLICATE('* ', (@cnt))
 SET @cnt = @cnt + 1;
END;