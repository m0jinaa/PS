import sys

def solve():
    n = int(sys.stdin.readline().rstrip())
    district = [list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(n)]
    district.sort()

    s = 1
    e = 2*int(1e9)
    answer = 0
    while s<=e:
        m = (s+e)//2
        ep = district[0][0]
        cnt = 1
        for a,b in district[1:]:
            if ep+m<=a+b:
                ep = max(ep+m,a)
                cnt+=1
            else:
                break
        if cnt == n:
            answer = m
            s = m+1
        else:
            e = m-1
    print(answer)

if __name__ == '__main__':
    solve()