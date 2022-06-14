import sys

def solve():
    n,m = map(int,sys.stdin.readline().rstrip().split())
    num = list(map(int,sys.stdin.readline().rstrip().split()))

    l = 0
    r = max(num)

    answer = 0
    while l<=r:
        mid = (l+r)//2
        cnt = 1
        s = num[0]
        b = num[0]
        for i in num:
            ns = min(s,i)
            nb = max(b,i)
            if nb-ns>mid:
                cnt+=1
                s = i
                b = i
            else:
                s = ns
                b = nb
        if cnt<=m:
            answer = mid
            r = mid-1
        else:
            l = mid+1
    print(answer)

if __name__ == '__main__':
    solve()