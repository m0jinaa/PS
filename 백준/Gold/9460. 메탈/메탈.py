import sys

def solve():
    t = int(sys.stdin.readline().rstrip())
    for _ in range(t):
        n,k = map(int,sys.stdin.readline().rstrip().split())
        p = list(map(int,sys.stdin.readline().rstrip().split()))
        po = [[p[2*i],p[2*i+1]] for i in range(n)]
        po.sort()
        height = [po[i][1] for i in range(n)]
        s = 0
        e = 2*int(1e8)
        answer = 0
        while s<=e:
            m = (s+e)//2
            l = sys.maxsize
            h = -sys.maxsize
            cnt = 1
            for i in height:
                l = min(l,i)
                h = max(h,i)
                if h-l>m:
                    cnt+=1
                    l = i
                    h = i
            if cnt<=k:
                answer = m/2
                e = m-1
            else:
                s = m+1
        print(answer)

if __name__ == '__main__':
    solve()