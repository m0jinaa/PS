import sys
from collections import deque

n,k = map(int,sys.stdin.readline().rstrip().split())
inf = sys.maxsize
q = deque()
q.append([n,0])
answer = 100001
v = [inf]*100001
v[n] = 0
while q:
    p,c = q.popleft()

    if 0<=p*2<=100000:
        if v[p*2]>c:
            v[p*2] = c
            q.appendleft([p*2,c])
    if 0<=p-1<=100000:
        if v[p-1]>c+1:
            v[p-1] = c+1
            q.append([p-1,c+1])
    if 0<=p+1<=100000:
        if v[p+1]>c+1:
            v[p+1] = c+1
            q.append([p+1,c+1])
print(v[k])
