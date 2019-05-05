LETTER_COUNT=26
s1=raw_input().strip()
s2=raw_input().strip()
count=[0]*LETTER_COUNT
for c in s1:
    count[ord(c)-97]+=1
for c in s2:
    count[ord(c)-97]-=1
print sum([ x if x>0 else -x for x in count ])