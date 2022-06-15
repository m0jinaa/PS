import sys

def solve():
    n,m = map(int,sys.stdin.readline().rstrip().split())
    c1,c2 = map(int,sys.stdin.readline().rstrip().split())

    p = list(map(int,sys.stdin.readline().rstrip().split()))
    q = list(map(int,sys.stdin.readline().rstrip().split()))
    q.sort()
    y = abs(c1-c2)
    answer = 0
    count = 0
    r = sys.maxsize
    for a in p:
        s = 0
        e = len(q)-1
        while s<=e:
            mid = (s+e)//2
            val = q[mid]-a

            if abs(val)<r:
                r = abs(val)
                count = 1
            elif abs(val) == r:
                count+=1
            if val<0:
                s = mid+1
            else:
                e = mid-1
    print(r+y,count)


if __name__ == '__main__':
    solve()