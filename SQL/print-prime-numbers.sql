/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
Declare @table table (primeno int) 
Declare @test as varchar(1000) 
set @test='' 
Declare @counter int 
set @counter = 2 
while @counter <= 1000 
begin 
if not exists(select top 1 primeno from @table where @counter % primeno = 0 ) 
Begin 
 insert into @table 
 select @counter 
 set @test=@test+CAST(@counter as varchar(20))+'&' 
end 
if @counter > 2
set @counter = @counter + 2 
else
set @counter =@counter + 1
end 
select SubString(@test,0,len(@test))