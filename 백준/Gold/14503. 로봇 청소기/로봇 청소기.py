import sys
from collections import deque
n,m = map(int,sys.stdin.readline().rstrip().split())
r,c,d = map(int,sys.stdin.readline().rstrip().split())

g = [list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(n)]

v = [[0]*m for _ in range(n)]
q = deque()
q.append([r,c,d])
v[r][c] = 1

cnt = 1
dx = [0,1,0,-1]
dy = [-1,0,1,0]
while q:
    a,b,d = q.popleft()
    f = 0
    for i in range(4):
        x = a+dx[(i+4-d)%4]
        y = b+dy[(i+4-d)%4]
        if 0<=x<n and 0<=y<m:
            if g[x][y] == 0 and v[x][y] == 0:
                cnt+=1
                v[x][y] = cnt
                q.append([x,y,(d-i+3)%4])
                break
            else:
                f+=1
    
    if f == 4:
        x = a+dx[(5-d)%4]
        y = b+dy[(5-d)%4]
        if 0<=x<n and 0<=y<m:
            if g[x][y] == 0:
                q.append([x,y,d])
            else:
                break
        else:
            break

print(cnt)
