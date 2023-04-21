import sys
from bisect import bisect_left

def solve():
    n = int(sys.stdin.readline().rstrip())
    a = list(map(int,sys.stdin.readline().rstrip().split()))
    v = []
    dp = []
    for i in a:
        s = bisect_left(v,i)
        if s == len(v):
            v.append(i)
        else:
            v[s] = i
        dp.append(s)
    s = len(v)
    print(s)
    answer = []

    for i in range(n-1,-1,-1):
        if dp[i] == s-1:
            answer.append(a[i])
            s-=1
    answer.reverse()
    print(*answer)

if __name__ == '__main__':
    solve()