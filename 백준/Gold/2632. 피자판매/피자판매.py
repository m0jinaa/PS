import sys
from collections import defaultdict

def solve():
    size = int(sys.stdin.readline().rstrip())
    n,m = map(int,sys.stdin.readline().rstrip().split())
    A = list(int(sys.stdin.readline().rstrip()) for _ in range(n))
    B = list(int(sys.stdin.readline().rstrip()) for _ in range(m))
    countA = defaultdict(int)
    countB = defaultdict(int)
    pieceA = set([0,sum(A)])
    pieceB = set([0,sum(B)])
    countA[0] = 1
    countA[sum(A)] = 1
    countB[0] = 1
    countB[sum(B)] = 1
    A.extend(A[:-1])
    B.extend(B[:-1])
    for i in range(1,n):
        for s in range(n):
            v = sum(A[s:s+i])
            pieceA.add(v)
            countA[v]+=1
    for i in range(1,m):
        for s in range(m):
            v = sum(B[s:s+i])
            pieceB.add(v)
            countB[v]+=1
    pieceA = list(pieceA)
    pieceB = list(pieceB)
    pieceA.sort()
    pieceB.sort()
    answer = 0
    for a in pieceA:
        if a>size:
            break
        s = 0
        e = len(pieceB)-1
        while s<=e:
            mid = (s+e)//2
            val = a+pieceB[mid]
            if val == size:
                answer+=countA[a]*countB[pieceB[mid]]
                break
            elif val<size:
                s = mid+1
            else:
                e = mid-1
    print(answer)

if __name__ == '__main__':
    solve()