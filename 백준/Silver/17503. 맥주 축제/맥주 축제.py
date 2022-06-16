import sys

def solve():
    n,m,k = map(int,sys.stdin.readline().rstrip().split())
    s = sys.maxsize
    e = 0
    beer = []
    for _ in range(k):
        a,b = map(int,sys.stdin.readline().rstrip().split())
        s = min(s,b)
        e = max(e,b)
        beer.append([a,b])

    beer.sort(key = lambda x: -x[0])
    answer = -1
    while s<=e:
        mid = (s+e)//2
        total = 0
        cnt = 0
        for p,d in beer:
            if cnt == n:
                break
            if d<=mid:
                total+=p
                cnt+=1
        if cnt==n and total>=m:
            answer = mid
            e = mid-1
        else:
            s = mid+1
    print(answer)

if __name__ == '__main__':
    solve()