/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
Select company_code, Founder , (select count(distinct lead_manager_code) from Lead_Manager where Lead_Manager.company_code=c.company_code),(select count(distinct Senior_Manager_code) from Senior_Manager where Senior_Manager.company_code=c.company_code),(select count(distinct Manager_code) from Manager  where Manager .company_code=c.company_code),(select count(distinct Employee_code) from Employee where Employee.company_code=c.company_code) from Company c order by  Company_code;