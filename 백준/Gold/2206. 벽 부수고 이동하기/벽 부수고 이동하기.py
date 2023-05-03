import sys
from collections import deque

n,m = map(int,sys.stdin.readline().rstrip().split())

g = [list(map(int,list(sys.stdin.readline().rstrip()))) for _ in range(n)]
inf = sys.maxsize
v = [[[inf,inf] for _ in range(m)] for _ in range(n)]

q = deque()
q.append([0,0,1,0])#x,y,flag

dx = [0,0,1,-1]
dy = [1,-1,0,0]
answer = -1
v[0][0][0] = 1
while q:
    a,b,c,f = q.popleft()
    if a==n-1 and b==m-1:
        answer = c;
        break
    #print(a,b,c,f)
    for i in range(4):
        x = a+dx[i]
        y = b+dy[i]

        if 0<=x<n and 0<=y<m:
            if g[x][y] == 0 and v[x][y][f] >c+1:
                v[x][y][f] = c+1
                q.append([x,y,c+1,f])
            elif g[x][y] == 1 and v[x][y][f] > c+1  and f == 0:
                v[x][y][f] = c+1
                q.append([x,y,c+1,1])
print(answer)