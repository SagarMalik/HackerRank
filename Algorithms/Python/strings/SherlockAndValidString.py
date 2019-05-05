sentence=raw_input()
placeholder=[0]*26
for x in sentence:
    CODE_X=ord(x)
    placeholder[CODE_X-97]+=1
Max_freq=max(placeholder)
Min_Freq=min([x for x in placeholder if x>0])
Max_Freq_COUNT=sum([1 for x in placeholder if x==Max_freq])
Min_Freq_COUNT=sum([1 for x in placeholder if x==Min_Freq])
if Max_freq==Min_Freq:
    changes_required=0
elif Max_freq==Min_Freq+1 and Max_Freq_COUNT==1:
    changes_required=sum([1 for x in placeholder if x==Max_freq])
else:
    changes_required=sum([x for x in placeholder if x==Min_Freq])
result='YES' if changes_required<=1 else 'NO'
print result