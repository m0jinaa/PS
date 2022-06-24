import sys

def solve():
    n,k = map(int,sys.stdin.readline().rstrip().split())

    s = 0
    e = n//2
    possible = False
    while s<=e:
        hc = (s+e)//2
        vc = n-hc

        cnt = (hc+1)*(vc+1)
        if cnt == k:
            print("YES")
            possible = True
            break
        elif k>cnt:
            s = hc+1
        else:
            e = hc-1
    if not possible:
        print("NO")

if __name__ == '__main__':
    solve()