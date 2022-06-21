import sys,heapq

def find(r,x):
    if r[x] !=x:
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
    n,m = map(int,sys.stdin.readline().rstrip().split())

    edge = []
    for i in range(n):
        l = list(sys.stdin.readline().rstrip())
        for j in range(i+1,n):
            if l[j] == "Y":
                heapq.heappush(edge,[i,j])
    if len(edge)<m:
        print(-1)
        exit()

    root = [i for i in range(n)]
    remain = []
    count = [0]*n
    edge_cnt = 0
    while edge:
        a,b = heapq.heappop(edge)
        if find(root,a)!=find(root,b):
            union(root,a,b)
            count[a] += 1
            count[b] += 1
            edge_cnt+=1
        else:
            heapq.heappush(remain,[a,b])

    if edge_cnt!=n-1:
        print(-1)
    else:
        for _ in range(m-edge_cnt):
            a,b = heapq.heappop(remain)
            count[a]+=1
            count[b]+=1
        print(*count)

if __name__ == '__main__':
    solve()