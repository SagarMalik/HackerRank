def changes(first,second):
    #print first,second
    arr=[0]*26
    for c in second:
        arr[ord(c)-97]=arr[ord(c)-97]+1
    
    for c in first:
        arr[ord(c)-97]-=1
        #print 'c->',c,sum(arr)
    return sum([x if x>0 else -x for x in arr])/2

n=int(raw_input())
while n>0:
    bigstr=raw_input()
    l=len(bigstr)
    if l%2==1:
        print -1
    else:
        first,second=bigstr[:l/2],bigstr[l/2:]
        print changes(first,second)
    n-=1
    
