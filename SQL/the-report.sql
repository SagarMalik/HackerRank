/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
Select St.Name, Gr.Grade, St.Marks from Students St , Grades Gr where st.Marks between Gr.Min_Mark and Gr.Max_Mark and Gr.Grade > 7 ORDER BY Gr.Grade DESC, St.Name;
Select 'NULL', Gr.Grade, St.Marks from Students St , Grades Gr where st.Marks between Gr.Min_Mark and Gr.Max_Mark and Gr.Grade < 8 ORDER BY Gr.Grade DESC,St.Marks;