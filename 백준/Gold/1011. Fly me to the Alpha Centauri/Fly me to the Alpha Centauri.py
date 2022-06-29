import sys

t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    x,y = map(int,sys.stdin.readline().rstrip().split())

    n = int((y-x)**0.5)
    
    if y-x == n*n:
        print(2*n-1)
    elif y-x-(n*n) <=n:
        print(2*n)
    else:
        print(2*n+1)
