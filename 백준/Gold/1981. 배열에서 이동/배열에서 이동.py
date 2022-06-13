import sys
from collections import deque

dx = [0,0,1,-1]
dy = [1,-1,0,0]

def bfs(g,v,s,e):
    if g[0][0]<s or g[0][0]>e:
        return False
    global cnt
    cnt+=1
    v[0][0] = cnt
    q = deque()
    q.append([0,0])
    n = len(g)

    while q:
        a,b = q.popleft()
        if a == n-1 and b == n-1:
            return True
        for i in range(4):
            x = a+dx[i]
            y = b+dy[i]
            if 0<=x<n and 0<=y<n and v[x][y] != cnt and s<=g[x][y]<=e:
                v[x][y] = cnt
                q.append([x,y])
    return False

def solve():
    answer = sys.maxsize
    n = int(sys.stdin.readline().rstrip())
    g = []
    s = sys.maxsize
    e = 0
    num = set()
    for _ in range(n):
        li = list(map(int,sys.stdin.readline().rstrip().split()))
        num = num.union(li)
        g.append(li)
    num = sorted(list(num))

    v = [[0]*n for _ in range(n)]
    global cnt
    cnt = 0

    l,r = 0,0
    while l<len(num) and r< len(num):
        if bfs(g,v,num[l],num[r]):
            if l == r:
                answer = 0
                break
            else:
                answer = min(answer,abs(num[r]-num[l]))
                l+=1
        else:
            r+=1
    print(answer)

if __name__ == '__main__':
    solve()