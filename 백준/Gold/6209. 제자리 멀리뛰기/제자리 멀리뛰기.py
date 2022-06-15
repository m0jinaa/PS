import sys

def solve():
    d,n,m = map(int,sys.stdin.readline().rstrip().split())
    po = [int(sys.stdin.readline().rstrip()) for _ in range(n)]
    po.append(0)
    po.append(d)
    po.sort()

    dist = [po[i+1]-po[i] for i in range(len(po)-1)]

    s = min(dist)
    e = sum(dist)+1
    answer = 0

    while s<=e:
        mid = (s+e)//2
        cnt = 0
        total = 0
        for p in dist:
            total+=p
            cnt+=1
            if total>=mid:
                cnt-=1
                total = 0
        if cnt>m:
            e = mid-1
        else:
            answer = mid
            s = mid+1
    print(answer)

if __name__ == '__main__':
    solve()