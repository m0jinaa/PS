import sys

dx = [0,0,1,-1]
dy = [1,-1,0,0]
dq = []
line = []
def dfs(g,v,i,j,k):
    q = []
    q.append([i,j])
    v[i][j] = k
    n = len(g)
    m = len(g[0])
    while q:
        a,b = q.pop()
        for t in range(4):
            x = a+dx[t]
            y = b+dy[t]
            if 0<=x<n and 0<=y<m:
                if g[x][y] == 1:
                    if v[x][y] == 0:
                        v[x][y] = k
                        q.append([x,y])
                else:
                    dq.append([a,b,t,k,0])

def bfs(v):
    n = len(v)
    m = len(v[0])

    while dq:
        a,b,d,k,val = dq.pop()
        x = a+dx[d]
        y = b+dy[d]
        if 0<=x<n and 0<=y<m:
            if v[x][y] == 0:
                dq.append([x,y,d,k,val+1])
            elif v[x][y] != k and val>=2:
                line.append([k,v[x][y],val])

def find(root,x):
    if x != root[x]:
        root[x] = find(root,root[x])
    return root[x]

def union(root,a,b):
    a = find(root,a)
    b = find(root,b)
    if a<b:
        root[b] = a
    else:
        root[a] = b

def solve():
    n,m = map(int,sys.stdin.readline().rstrip().split())
    g = [list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(n)]
    v = [[0]*m for _ in range(n)]
    k = 1
    for i in range(n):
        for j in range(m):
            if g[i][j] == 1 and v[i][j] == 0:
                dfs(g,v,i,j,k)
                k+=1

    root = [i for i in range(k)]

    bfs(v)

    line.sort(key = lambda x: x[2])

    answer = 0

    for a,b,c in line:
        if find(root,a) != find(root,b):
            union(root,a,b)
            answer+=c

    val = find(root,1)
    for i in range(2,k):
        if find(root,i) != val:
            print(-1)
            exit()
    print(answer)

if __name__ == '__main__':
    solve()