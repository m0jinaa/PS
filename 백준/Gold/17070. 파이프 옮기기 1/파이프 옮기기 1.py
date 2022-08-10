import sys

n = int(sys.stdin.readline().rstrip())
g = [list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(n)]

v = [[[0]*3 for _ in range(n)]for _ in range(n)]
v[0][1][0] = 1
for i in range(2,n):
    if g[0][i] == 1:
        v[0][i][0] = 0
    else:
        v[0][i][0] = v[0][i-1][0]

for i in range(1,n):
    for j in range(1,n):
        #가로
        if g[i][j] == g[i][j-1] == 0:
            v[i][j][0] = v[i][j-1][0]+v[i][j-1][2]
        #세로
        if g[i][j] == g[i-1][j] == 0:
            v[i][j][1] = v[i-1][j][1]+v[i-1][j][2]
        # 대각선
        if g[i][j] == g[i][j-1] == g[i-1][j] == 0:
            v[i][j][2] = sum(v[i-1][j-1])
print(sum(v[-1][-1]))           