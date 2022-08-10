import sys
from collections import deque
n = int(sys.stdin.readline().rstrip())

g = [[0]*n for _ in range(n)]

k = int(sys.stdin.readline().rstrip())
for _ in range(k):
    a,b = map(int,sys.stdin.readline().rstrip().split())
    g[a-1][b-1] = 1
l = int(sys.stdin.readline().rstrip())

di = {}
for _ in range(l):
    a,b = sys.stdin.readline().rstrip().split()
    a = int(a)
    di[a] = b


d = 0
dx = [0,1,0,-1]
dy = [1,0,-1,0]
t = 0

v = [[0]*n for _ in range(n)]
v[0][0] = 1
snake = deque()
snake.append([0,0])
x = 0
y = 0

while True:
    t+=1
    x +=dx[d]
    y +=dy[d]

    if 0<=x<n and 0<=y<n:
        snake.append([x,y])
        if v[x][y] == 0:
            v[x][y] = 1
        else:# 뱀의 몸과 충돌
            break
        if g[x][y] == 1:
            g[x][y] = 0
        else:
            a,b = snake.popleft()
            v[a][b] = 0
    else:#보드에서 벗어남
        break
    try:
        if di[t] == "D":
            d = (d+1)%4
        else:
            d = (d+3)%4
    except:
        pass
print(t)
