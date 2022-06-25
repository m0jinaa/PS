import sys

def solve():
    n,m = map(int,sys.stdin.readline().rstrip().split())

    food = [list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(n)]

    s = 1
    e = int(1e18)

    answer = 0
    while s<=e:
        mid = (s+e)//2
        total = 0
        mtotal = 0
        for a,b in food:
            if b<=mid:
                total+=a
                mtotal = max(total,mtotal)
            else:
                total = 0
        if mtotal>=m:
            answer = mid
            e = mid-1
        else:
            s = mid+1
    print(answer)

if __name__ == '__main__':
    solve()