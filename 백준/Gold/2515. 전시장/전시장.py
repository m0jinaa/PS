import sys
from bisect import bisect_right
def solve():
    n,s = map(int,sys.stdin.readline().rstrip().split())

    painting = [list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(n)]
    painting.sort()
    h = []
    w = []
    for a,b in painting:
        h.append(a)
        w.append(b)
    dp = [0]*n

    for i in range(n):
        ind = bisect_right(h,h[i]-s)
        x = 0
        if ind !=0:
            x = dp[ind-1]
        if i == 0:
            dp[i] = max(0, w[i]+x)
        else:
            dp[i] = max(dp[i-1],w[i]+x)
    print(dp[-1])

if __name__ == '__main__':
    solve()