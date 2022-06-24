import sys

def solve():
    t = int(sys.stdin.readline().rstrip())

    for _ in range(t):
        n,k = map(int,sys.stdin.readline().rstrip().split())

        number = list(map(int,sys.stdin.readline().rstrip().split()))
        number.sort()

        s = 0
        e = n-1
        diff = sys.maxsize
        answer = 0
        while s<e:
            v = number[s]+number[e]-k
            if abs(v)<diff:
                diff = abs(v)
                answer = 1
            elif abs(v) == diff:
                answer+=1

            if v<0:
                s+=1
            elif v>0:
                e-=1
            else:
                s+=1
                e-=1
        print(answer)

if __name__ == '__main__':
    solve()