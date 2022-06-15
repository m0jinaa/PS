import sys

def solve():
    l,k,c = map(int,sys.stdin.readline().rstrip().split())
    po = list(set(map(int,sys.stdin.readline().rstrip().split())))
    po.append(0)
    po.append(l)
    po.sort()

    dist = [po[i]-po[i-1] for i in range(len(po)-1,0,-1)]

    s = 0
    e = l
    limit = max(dist)

    answer = [0,0]
    while s<=e:
        m = (s+e)//2
        if limit>m:
            s = m+1
            continue
        total = 0
        cnt = 0
        for d in dist:
            total+=d
            if total>m:
                cnt+=1
                total = d
        if cnt != c:
            total = dist[-1]
        if cnt<=c:
            answer = [m,total]
            e = m-1
        else:
            s = m+1
    print(*answer)

if __name__ == '__main__':
    solve()