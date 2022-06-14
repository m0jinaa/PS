import sys

def solve():
    n,m,l = map(int,sys.stdin.readline().rstrip().split())
    po = list(map(int,sys.stdin.readline().rstrip().split()))
    po.append(0)
    po.append(l)
    po.sort()
    d = [po[i]-po[i-1] for i in range(1,len(po))]
    s = 1
    e = l
    answer = 0
    while s<=e:
        mid = (s+e)//2
        cnt = 0
        for x in d:
            if x>mid:
                cnt+=(x-1)//mid
        if cnt<=m:
            answer = mid
            e = mid-1
        else:
            s = mid+1
    print(answer)

if __name__ == '__main__':
    solve()