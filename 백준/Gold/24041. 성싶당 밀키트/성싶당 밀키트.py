import sys

def solve():
    n,g,k = map(int,sys.stdin.readline().rstrip().split())
    ingredient = [list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(n)]
    s = 0
    e = int(2e9)

    answer = 0
    while s<=e:
        mandatory = []
        addition = []
        total = 0
        m = (s+e)//2
        for a,b,c in ingredient:
            v = m-b if m>b else 1

            if c == 1:
                addition.append(a*v)
            else:
                total+=a*v
        if k!=0:
            addition.sort()
            total += sum(addition[:-k])
        else:
            total+=sum(addition)

        if total<=g:
            answer = m
            s = m+1
        else:
            e = m-1
    print(answer)

if __name__ == '__main__':
    solve()