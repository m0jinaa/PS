import sys
from collections import deque
from math import sqrt

def check(a,x,f,k):
    n = len(a)
    v = [False]*n
    cnt = 0
    q = deque()
    q.append(x)

    while q:
        if cnt>k:
            return False
        j = len(q)
        for _ in range(j):
            u = q.popleft()
            p = a[u]
            if not v[u]:
                v[u] = True
                for i in range(1,n):
                    d = sqrt(pow(p[0]-a[i][0],2)+pow(p[1]-a[i][1],2))

                    if d<=f:
                        dist = sqrt(pow(10000-a[i][0],2)+pow(10000-a[i][1],2))
                        if dist<=f:
                            return True
                        q.append(i)
        cnt+=1
    return False


def solve():
    n,k = map(int,sys.stdin.readline().rstrip().split())
    airport = [[0,0]]+list(list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(n))

    l = 0
    r = 10000
    answer = 0

    while l<=r:
        m = (l+r)//2
        if check(airport,0,m*10,k):
            answer = m
            r = m-1
        else:
            l = m+1
    print(answer)

if __name__ == '__main__':
    solve()