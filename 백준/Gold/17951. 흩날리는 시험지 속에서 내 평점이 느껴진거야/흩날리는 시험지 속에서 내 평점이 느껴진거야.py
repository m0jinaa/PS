import sys

def solve():
    n,k = map(int,sys.stdin.readline().rstrip().split())
    point = list(map(int,sys.stdin.readline().rstrip().split()))

    s = 1
    e = 10**5*20+1

    answer = 0
    while s<=e:
        m = (s+e)//2
        cnt = 0
        total = 0
        for p in point:
            total+=p
            if total>=m:
                cnt+=1
                total = 0
        if cnt>=k:
            answer = m
            s = m+1
        else:
            e = m-1

    print(answer)

if __name__ == '__main__':
    solve()