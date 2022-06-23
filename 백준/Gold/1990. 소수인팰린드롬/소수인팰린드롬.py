import sys

def check(x):
    n = str(x)
    if n != n[::-1]:
        return False
    
    for i in range(2,int(x**0.5)+1):
        if x%i == 0:
            return False
    return True

def solve():
    a,b = map(int,sys.stdin.readline().rstrip().split())
    if b >10000000:
        b = 10000000
    for n in range(a,b+1):
        if check(n):
            print(n)
    print(-1)

if __name__ == '__main__':
    solve()