import sys
from collections import defaultdict

n = int(sys.stdin.readline().rstrip())
g = list(map(int,sys.stdin.readline().rstrip().split()))

p = sum(g)//4
if p == 0:
    c = 0
    s = 0
    for i in g:
        s+=i
        if s == 0:
            c+=1
    c-=1
    print(c*(c-1)*(c-2)//6)
else:
    v = defaultdict(int)

    v[0] = 1
    s = 0
    for i in g:
        s+=i
        if s%p == 0:
            v[s]+=v[s-p]
    print(v[s])