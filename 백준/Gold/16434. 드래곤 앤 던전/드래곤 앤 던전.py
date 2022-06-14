import sys

def solve():
    n,po = map(int,sys.stdin.readline().rstrip().split())
    info = [list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(n)]

    l = 1
    r = int(1e18)
    answer = 0
    while l<=r:
        p = po
        m = (l+r)//2
        h = m
        for c,a,b in info:
            if c == 2:
                p+=a
                h = min(h+b,m)
            else:
                attack = b//p
                if b%p:
                    attack+=1

                if h-(attack-1)*a <=0:
                    h = -1
                    break
                else:
                    h -=(attack-1)*a
        if h>0:
            answer = m
            r = m-1
        else:
            l = m+1
    print(answer)

if __name__ == '__main__':
    solve()