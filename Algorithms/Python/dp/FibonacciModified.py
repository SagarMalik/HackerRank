# Enter your code here. Read input from STDIN. Print output to STDOUT
import sys
params= sys.stdin.readline().split(' ')
t1=int(params[0])
t2=int(params[1])
n=int(params[2])
for i in xrange(n-2):
    temp=t2
    t2=t1+t2**2
    t1=temp
    
    
print t2