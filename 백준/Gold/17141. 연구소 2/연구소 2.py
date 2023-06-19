import sys
from itertools import combinations
from collections import deque
from copy import deepcopy


def bfs(g, r):
    q = deque(r)
    cnt = 0
    v = [[0] * n for _ in range(n)]
    for x, y, z in r:
        v[x][y] = 1
        g[x][y] = 2
    while q:
        a, b, c = q.popleft()
        for i in range(4):
            x = a + dx[i]
            y = b + dy[i]
            if 0 <= x < n and 0 <= y < n and g[x][y] != 1 and v[x][y] == 0:
                cnt = c + 1
                v[x][y] = 1
                g[x][y] = 2
                q.append([x, y, c + 1])

    for i in range(n):
        for j in range(n):
            if g[i][j] == 0:
                return inf
    return cnt


inf = sys.maxsize
n, m = map(int, sys.stdin.readline().rstrip().split())
graph = []
candidate = []
for i in range(n):
    l = list(map(int, sys.stdin.readline().rstrip().split()))
    for j in range(n):
        if l[j] == 2:
            candidate.append([i, j, 0])
            l[j] = 0
    graph.append(l)

virus = list(combinations(candidate, m))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

answer = inf
for vir in virus:
    g = deepcopy(graph)
    answer = min(answer, bfs(g, vir))
if answer == inf:
    print(-1)
else:
    print(answer)