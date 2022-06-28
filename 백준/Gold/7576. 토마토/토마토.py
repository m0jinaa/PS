import sys
from collections import deque
def bfs(g,n,m):
    q = deque()
    v = [[0 for _ in range(m)] for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if g[i][j] == 1:
                q.append([i,j])
            elif g[i][j] == -1:
                v[i][j] = -1
    answer = 0
    while q:
        p = q.popleft()
        c = v[p[0]][p[1]]
        dx = [1,-1,0,0]
        dy = [0,0,1,-1]

        for i in range(4):
            x = p[0]+dx[i]
            y = p[1]+dy[i]
            if x in range(n) and y in range(m):
                if g[x][y] == 0:
                    g[x][y] = 1
                    v[x][y] = c+1
                    answer = max(answer,c+1)
                    q.append([x,y])
    for w in g:
        for z in w:
            if z == 0:
                print(-1)
                return
    
    print(answer)

m,n = map(int,input().split())
graph = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]

bfs(graph,n,m)