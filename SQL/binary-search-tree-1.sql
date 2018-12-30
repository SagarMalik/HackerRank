/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
WITH GROUPTBL AS (
SELECT NODE , MAX(PARENT) AS PARENTNODE,COUNT(CHILD) AS CHILDS FROM(Select A.N AS NODE, A.P AS PARENT, B.N AS CHILD from BST A left join BST B on A.N=B.P) DETATILEDTB GROUP BY NODE)
SELECT NODE, CASE WHEN PARENTNODE IS NULL THEN 'Root' WHEN CHILDS=0 THEN 'Leaf' Else 'Inner' END FROM GROUPTBL order by NODE;