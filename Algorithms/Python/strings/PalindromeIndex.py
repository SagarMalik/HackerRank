def isPalindrome(st):
    return st==st[::-1]
            

N=int(raw_input())
for _ in xrange(N):
    S=raw_input()
    if isPalindrome(S):
        print "-1"
    else:
        palin=False
        i=0
        j=len(S)-1
        while i<=j:
            
            while S[i]==S[j] and i<=j:
                i=i+1
                j=j-1
            mostring=S[i+1:j+1]
            if isPalindrome(mostring):
                palin=True
                print i
                break
            else:
                mostring=S[i:j]
                if isPalindrome(mostring):
                    palin=True
                    print j
                    break
            i,j=i+1,j-1
        if palin!=True:
            print "-1"
                