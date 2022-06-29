import sys
from collections import deque

t = int(sys.stdin.readline().rstrip())
for _ in range(t):
    n,k = map(int,sys.stdin.readline().rstrip().split())
    v = [[] for _ in range(n+1)]
    g = [[] for _ in range(n+1)]
    
    cnt = [0]*(n+1)
    
    time = [0]+list(map(int,sys.stdin.readline().rstrip().split()))

    for _ in range(k):
        a,b = map(int,sys.stdin.readline().rstrip().split())
        v[a].append(b)
        g[b].append(a)
        cnt[b]+=1

    
    w = int(sys.stdin.readline().rstrip())

    q = deque()

    for i in range(1,n+1):
        if cnt[i] == 0:
            q.append(i)

    while q:
        p = q.popleft()

        m = 0
        for i in g[p]:
            m = max(m,time[i])
        time[p]+=m
        
        for i in v[p]:
            cnt[i]-=1
            if cnt[i] == 0:
                q.append(i)
        
    print(time[w])