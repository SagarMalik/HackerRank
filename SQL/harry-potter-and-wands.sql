/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
with tbl2 as (
Select min (w1.coins_needed) as mincoins, w1.power as minpower, wp1.age as age from  wands w1 inner join wands_property wp1 on w1.code=wp1.code
group by w1.power , wp1.age )
Select w.id , wp.age , tbl2.mincoins , w.power from  wands w , wands_property wp, tbl2 where w.code=wp.code
and wp.age = tbl2.age
and w.power=tbl2.minpower
and wp.is_evil=0
and w.coins_needed=tbl2.mincoins
order by w.power desc, wp.age desc;