import sys
   
n = int(sys.stdin.readline().rstrip())

g = [list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(n)]

v = [[0]*3 for _ in range(n)]

v[0] = g[0]

for i in range(1,n):
    v[i][0] = min(v[i-1][1],v[i-1][2])+g[i][0]
    v[i][1] = min(v[i-1][0],v[i-1][2])+g[i][1]
    v[i][2] = min(v[i-1][1],v[i-1][0])+g[i][2]

print(min(v[-1]))