import sys

def solve():
    n = int(sys.stdin.readline().rstrip())
    a = list(map(int,sys.stdin.readline().rstrip().split()))

    v = [0]

    for i in a:
        if v[-1]<i:
            v.append(i)
        else:
            l = 0
            r = len(v)
            while l<r:
                m = (r+l)//2
                if v[m]<i:
                    l = m+1
                else:
                    r = m
            v[r] = i
    print(len(v)-1)
if __name__ == '__main__':
    solve()