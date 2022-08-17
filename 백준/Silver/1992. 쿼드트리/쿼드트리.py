import sys
def cp(g,x,y,n):
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
        return p
    else:
        d = n//2
        dx = [0,0,d,d]
        dy = [0,d,0,d]
        a = ""
        for k in range(4):
            nx = x+dx[k]
            ny = y+dy[k]
            a += cp(g,nx,ny,d)

        return "("+a+")"

nn = int(input())
graph = [sys.stdin.readline().rstrip() for _ in range(nn)]

answer = cp(graph,0,0,nn)

print(answer)
