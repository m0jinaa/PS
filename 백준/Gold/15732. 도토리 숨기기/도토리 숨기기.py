import sys

def solve():
    n,k,d = map(int,sys.stdin.readline().rstrip().split())
    rule = [list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(k)]

    s = 1
    e = n
    answer = 0
    while s<=e:
        m = (s+e)//2
        cnt = 0
        for a,b,c in rule:
            if a<=m<=b:
                cnt+=(m-a)//c+1
            elif b<m:
                cnt+=(b-a)//c+1
        if cnt>=d:
            answer = m
            e = m-1
        else:
            s = m+1
    print(answer)

if __name__ == '__main__':
    solve()