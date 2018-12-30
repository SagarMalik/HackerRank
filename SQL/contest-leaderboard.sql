/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
Select hc.hacker_id,min(hc.name),sum(sb.maxscore) from hackers hc ,  
(
Select s1.hacker_id as hackerid,s1.challenge_id as challengeid, max(s1.score) as maxscore
    from submissions s1 group by s1.hacker_id, s1.challenge_id
    
)sb
where hc.hacker_id=sb.hackerid
group by hc.hacker_id
having sum(sb.maxscore)!=0
order by sum(sb.maxscore) desc,hacker_id;