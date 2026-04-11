import sys
n,m = map(int,input().split())
g = [list(sys.stdin.readline().rstrip()) for _ in range(n)]
l = 0
if n<m:
    l = n
else:
    l = m
f = 0
for i in range(l,1,-1): #length of square
    for j in range(0,n-i+1):
        for k in range(0,m-i+1):
            if g[j][k] == g[j][k+i-1] == g[j+i-1][k] == g[j+i-1][k+i-1]:
                print(i*i)
                f = 1
                break
        if f == 1:
            break
    if f == 1:
        break
if f == 0:
    print(1)