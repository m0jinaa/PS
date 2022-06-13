import sys

def getC(x,y,z):
    a = (x**2-z**2)**0.5
    b = (y**2-z**2)**0.5
    ans = a*b/(a+b)
    return ans

def solve():
    x,y,c = map(float,sys.stdin.readline().rstrip().split())

    l = 0
    r = min(x,y)

    answer = 0

    while r-l > 0.000001:
        m = (l+r)/2
        if getC(x,y,m)>=c:
            answer = m
            l = m
        else:
            r = m

    print(answer)

if __name__ == '__main__':
    solve()