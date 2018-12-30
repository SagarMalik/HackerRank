/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
Select hc.hacker_id,min(hc.name) from hackers hc , submissions sb, challenges chl, difficulty diff
where sb.challenge_id=chl.challenge_id
and chl.difficulty_level=diff.difficulty_level
and  sb.score=diff.score
and  sb.hacker_id=hc.hacker_id
group by hc.hacker_id
having count(hc.hacker_id)>1
order by count(hc.hacker_id) desc, hc.hacker_id;