import sys
def cp(g,x,y,n):
    w,bl = 0,0

    p = g[x][y]
    e = 0
    for i in range(n):
        for j in range(n):
            if g[x+i][y+j] != p:
                e = 1
                break
        if e ==1:
            break
    if e == 0:
        if p == 0:
            return[1,0]
        else:
            return [0,1]
    else:
        d = n//2
        dx = [0,d,0,d]
        dy = [0,0,d,d]
        for k in range(4):
            nx = x+dx[k]
            ny = y+dy[k]
            a = cp(g,nx,ny,d)
            w+=a[0]
            bl+=a[1]
        return [w,bl]

nn = int(input())
graph = [list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(nn)]

answer = cp(graph,0,0,nn)

for a in answer:
    print(a)
