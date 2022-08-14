import sys

def dfs(arr,start):
    visited = [0 for _ in range(len(arr))]
    q = []
    q.append(start)
    parent = [0 for _ in range(len(arr))]
    
    while(q):
        p,r = q.pop()
        
        if visited[p] == 0:
            visited[p] = 1
            parent[p] = r
            for l in arr[p]:
                if visited[l] == 0:
                    q.append([l,p])
    return parent

n = int(sys.stdin.readline().rstrip())

graph = [[] for _ in range(n+1)]

for _ in range(n-1):
    a,b = map(int,sys.stdin.readline().rstrip().split())
    graph[a].append(b)
    graph[b].append(a)
answer = dfs(graph,[1,0])

for a in answer[2:]:
    print(a)