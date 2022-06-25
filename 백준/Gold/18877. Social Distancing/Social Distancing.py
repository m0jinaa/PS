import sys

def solve():
    n,m = map(int,sys.stdin.readline().rstrip().split())

    district = [list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(m)]
    district.sort()
    s = 1
    e = int(1e18)
    answer = 0
    while s<=e:
        mid = (s+e)//2
        cnt = 1
        ep = district[0][0]
        for a,b in district:
            while ep+mid<=b:
                ep = max(ep+mid,a)
                cnt+=1
        if cnt<n:
            e = mid-1
        else:
            answer = mid
            s = mid+1
    print(answer)

if __name__ == '__main__':
    solve()