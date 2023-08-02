import sys

def dfs(arr,v,start,h):
    q = []
    q.append(start)
    n = len(arr)
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    while q:
        #print(q)
        p = q.pop()
        if v[p[0]][p[1]] == 0:
            v[p[0]][p[1]] = 1
            for i in range(4):
                x = p[0]+dx[i]
                y = p[1]+dy[i]
                if x in range(0,n) and y in range(0,n):
                    if v[x][y] == 0 and arr[x][y] >h:
                        q.append((x,y))

w = int(sys.stdin.readline().rstrip())

graph = [list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(w)]
answer = 0
cnt = 1
h = 0
while cnt!=0:
    visited = [[0 for _ in range(w)] for _ in range(w)]
    cnt = 0
    for i in range(w):
        for j in range(w):
            if graph[i][j] >h and visited[i][j] == 0:
                dfs(graph,visited,(i,j),h)
                cnt+=1
    
    if cnt > answer:
        answer = cnt
    h+=1

print(answer)
