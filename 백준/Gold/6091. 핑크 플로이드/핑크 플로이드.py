import sys,heapq

def find(r,x):
    if x != r[x]:
        r[x] = find(r,r[x])
    return r[x]

def union(r,a,b):
    a = find(r,a)
    b = find(r,b)

    if a<b:
        r[b] = a
    else:
        r[a] = b

def solve():
    n = int(sys.stdin.readline().rstrip())
    root = [i for i in range(n+1)]

    answer = [[] for _ in range(n+1)]

    q = []

    for i in range(1,n):
        l = list(map(int,sys.stdin.readline().rstrip().split()))

        for j,item in zip(range(i+1,n+1),l):
            heapq.heappush(q,[item,i,j])

    while q:
        c,a,b = heapq.heappop(q)
        if find(root,a)!=find(root,b):
            union(root,a,b)
            answer[a].append(b)
            answer[b].append(a)
    for ans in answer[1:]:
        print(len(ans),*sorted(ans))

if __name__ == '__main__':
    solve()