T=int(raw_input().strip())
for _ in xrange(T):
    S=bytearray(raw_input())
    i,l,changes=0,len(S)-1,0
    while i<l:
        d=S[i]-S[l]
        changes+=d if d>0 else -d
        i,l=i+1,l-1
    print changes