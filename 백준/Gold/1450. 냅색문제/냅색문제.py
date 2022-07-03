import sys
from itertools import combinations

def solve():
    n,c = map(int,sys.stdin.readline().rstrip().split())
    g = list(map(int,sys.stdin.readline().rstrip().split()))
    g.sort()
    A = g[:n//2]
    B = g[n//2:]

    comA = []
    comB = []
    for i in range(len(A)+1):
        for l in combinations(A,i):
            comA.append(sum(l))

    for i in range(len(B)+1):
        for l in combinations(B,i):
            comB.append(sum(l))

    comB.sort()
    answer = 0

    for a in comA:
        if a>c:
            continue

        left = 0
        right = len(comB)-1
        while left<=right:
            m = (left+right)//2

            if a+comB[m]<=c:
                left = m+1
            else:
                right = m-1
        answer+=right+1
        
    print(answer)

if __name__ == '__main__':
    solve()