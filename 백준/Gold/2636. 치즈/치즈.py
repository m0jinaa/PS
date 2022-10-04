import sys
import heapq
def bfs():
    q = []
    heapq.heappush(q,[0,0,0])
    v[0][0] = 1
    n = len(g)
    m = len(g[0])
    d = {}
    while q:
        t,a,b = heapq.heappop(q)

        for i in range(4):
            x = a+dx[i]
            y = b+dy[i]

            if 0<=x<n and 0<=y<m:
                if v[x][y] == 0:
                    v[x][y] = 1
                    if g[x][y] == 0:
                        heapq.heappush(q,[t,x,y])
                    else:
                        heapq.heappush(q,[t+1,x,y])
                        try:
                            d[t]+=1
                        except:
                             d[t] = 1
    print(t)
    print(d[t-1])

n,m = map(int,sys.stdin.readline().rstrip().split())

g = [list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(n)]

v = [[0]*m for _ in range(n)]

dx = [0,0,1,-1]
dy = [1,-1,0,0]

bfs()
