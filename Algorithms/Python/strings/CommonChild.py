def LCS(st1,st2):
    m=len(st1)
    n=len(st2)
    c=[]
    for i in xrange(m+1):
        c.append([0]*n)
    for i in xrange(1,m+1):
        for j in xrange(1,n+1):
            if st1[i-1]==st2[j-1]:
                c[i][j]=c[i-1][j-1]+1
            else:
                c[i][j]=c[i-1][j] if c[i-1][j] > c[i][j-1] else c[i][j-1]
    return c[m][n]
            

st1=raw_input()
st2=raw_input()
print LCS(st1,st2)