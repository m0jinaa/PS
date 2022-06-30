import sys

def solve():
    s, e = map(int,sys.stdin.readline().rstrip().split())

    answer = e-s+1
    qn = [False]*(e-s+1)
    i = 2
    while i*i<=e:
        n = i*i

        r = 0 if s%n == 0 else 1
        j = s//n+r

        while n*j <= e:
            if not qn[n*j-s]:
                qn[n*j-s] = True
                answer-=1
            j+=1
        i+=1
    print(answer)


if __name__ == '__main__':
    solve()