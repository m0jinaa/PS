import sys

def solve():
    t = int(sys.stdin.readline().rstrip())
    for _ in range(t):
        n =int(sys.stdin.readline().rstrip())
        k = [int(sys.stdin.readline().rstrip()) for _ in range(n)]
        v = [0]

        for i in k:
            if v[-1]<i:
                v.append(i)
            else:
                l = 0
                r = len(v)
                while l<r:
                    m = (l+r)//2
                    if v[m]<i:
                        l = m+1
                    else:
                        r = m
                v[r] = i
        print(len(v)-1)

if __name__ == '__main__':
    solve()