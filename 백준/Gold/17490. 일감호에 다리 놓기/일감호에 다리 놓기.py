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
    n,m,k = map(int,sys.stdin.readline().rstrip().split())
    q = []
    l = list(map(int,sys.stdin.readline().rstrip().split()))

    for i,item in zip(range(1,n+1),l):
        heapq.heappush(q,[item,0,i])

    root = [i for i in range(n+1)]

    neighbor = set((i,i+1) if i <n else (i,1) for i in range(1,n+1))

    for _ in range(m):
        a,b = map(int,sys.stdin.readline().rstrip().split())
        if (a,b) in neighbor:
            neighbor.remove((a,b))
        elif (b,a) in neighbor:
            neighbor.remove((b,a))

    for a,b in neighbor:
        if find(root,a)!= find(root,b):
            union(root,a,b)

    val = find(root,1)
    e = 0
    for i in range(2,n+1):
        if find(root,i) != val:
            e = 1
    answer = 0
    if e == 1:

        while q:
            c,a,b = heapq.heappop(q)
            if find(root,a)!= find(root,b):
                answer+=c
                union(root,a,b)

    if answer<=k:
        print("YES")
    else:
        print("NO")

if __name__ == '__main__':
    solve()