import sys

def dfs(a,b,i,k):
    n = len(g)
    m = len(g[0])

    if i == 4:
        answer[0] = max(answer[0],k)
    else:
        for j in range(4):
            x = a+dx[j]
            y = b+dy[j]
            if 0<=x<n and 0<=y<m:
                if v[x][y] == 0:
                    v[x][y] = 1
                    dfs(x,y,i+1,k+g[x][y])
                    v[x][y] = 0
                        
def bfs(a,b):#ㅗ모양
    n = len(g)
    m = len(g[0])
    s = g[a][b]
    l = []
    for j in range(4):
        x = a+dx[j]
        y = b+dy[j]
        if 0<=x<n and 0<=y<m:
            l.append(g[x][y])
    if len(l)==4:
        s+=sum(l)-min(l)
        answer[0] = max(answer[0],s)
    elif len(l)==3:
        answer[0] = max(answer[0],s+sum(l))

n,m = map(int,sys.stdin.readline().rstrip().split())
g = [list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(n)]
  
dx = [0,0,1,-1]
dy = [1,-1,0,0]

v = [[0]*m for _ in range(n)]
answer = [0]
for i in range(n):
    for j in range(m):
        v[i][j] = 1
        dfs(i,j,1,g[i][j])
        v[i][j] = 0
        bfs(i,j)
print(answer[0])
