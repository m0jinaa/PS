import sys
import heapq

v,e = map(int,sys.stdin.readline().rstrip().split())
inf = sys.maxsize
k = int(sys.stdin.readline().rstrip())
dp  = [inf]*(v+1)

g = [[] for _ in range(v+1)]

for _ in range(e):
    a,b,c = map(int,sys.stdin.readline().rstrip().split())
    g[a].append([c,b])
    
dp[k] = 0

q = []

heapq.heappush(q,[0,k])

while q:
    cnt,p = heapq.heappop(q)

    if dp[p] <cnt:
        continue
    for c,b in g[p]:
        if c+cnt < dp[b]:
            dp[b] = c+cnt
            heapq.heappush(q,[c+cnt,b])

for a in dp[1:]:
    print("INF" if a == inf else a)
