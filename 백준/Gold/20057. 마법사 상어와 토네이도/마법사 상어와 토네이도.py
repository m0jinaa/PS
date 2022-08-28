import sys

dx = [0,1,0,-1]
dy = [-1,0,1,0]

r = [[-2,0,0.02],[-1,0,0.07],[-1,1,0.01],[-1,-1,0.1],[0,-2,0.05],[1,-1,0.1],[1,0,0.07],[1,1,0.01],[2,0,0.02]]
alpha = [0,-1]
d = 0

n = int(sys.stdin.readline().rstrip())
g = list(list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(n))

a = n//2
b = n//2
t = 1
cnt = 0
answer = 0

while a!=0 or b!=0:
    if cnt == 2:
        cnt = 0
        t +=1
    for _ in range(t):
        if a == b == 0:
            break
        a +=dx[d]
        b +=dy[d]
        if g[a][b] == 0:
            continue
        remains = g[a][b]

        for x,y,p in r:
            if d == 1:
                x,y = -y,x
            elif d == 2:
                x,y = -x,-y
            elif d == 3:
                x,y = y,-x
            na = a+x
            nb = b+y
            val = int(g[a][b]*p)
            if 0<=na<n and 0<=nb<n:
                g[na][nb]+=val
            else:
                answer+=val
            remains-=val
        
        x,y = alpha
        if d == 1:
            x,y = -y,x
        elif d == 2:
            x,y = -x,-y
        elif d == 3:
            x,y = y,-x
        na = a+x
        nb = b+y

        if 0<=na<n and 0<=nb<n:
            g[na][nb]+=remains
        else:
            answer+=remains
    cnt+=1
    d = (d+1)%4
        
print(answer)