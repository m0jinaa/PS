import sys
from math import sqrt
#kruscal

def find(i):
    if i !=vroot[i]:
        vroot[i] = find(vroot[i])
    return vroot[i]

n,m = map(int,sys.stdin.readline().rstrip().split())
dot = []
elist = []


for i in range(n):
    a,b = map(int,sys.stdin.readline().rstrip().split())
    for j in range(len(dot)):
        x,y = dot[j]
        val = sqrt((a-x)**2+(b-y)**2)
        elist.append([i,j,val])
        elist.append([j,i,val])
    dot.append([a,b])
                   
        
vroot = [i for i in range(n)]
for _ in range(m):
    a,b = map(int,sys.stdin.readline().rstrip().split())
    a = find(a-1)
    b = find(b-1)
    if a<b:
        vroot[b] = a
    else:
        vroot[a] = b

elist.sort(key = lambda x: x[2])


answer = 0

for s,e,w in elist:
    sroot = find(s)
    eroot = find(e)
    if sroot!=eroot:
        if sroot<eroot:
            vroot[eroot] = sroot
        else:
            vroot[sroot] = eroot
        answer+=w
print("{:.2f}".format(answer))
