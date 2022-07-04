import sys
from itertools import combinations

def solve():
    n,s = map(int,sys.stdin.readline().rstrip().split())

    g = list(map(int,sys.stdin.readline().rstrip().split()))
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
    comA.sort()
    comB.sort()

    i = 0
    j = len(comB)-1
    answer = 0
    while i<len(comA) and j>=0:
        val = comA[i]+comB[j]

        if val == s:
            ni = i+1
            nj = j-1
            while ni<len(comA) and comA[ni] == comA[i]:
                ni+=1
            while nj>=0 and comB[nj] == comB[j]:
                nj-=1

            answer+=(ni-i)*(j-nj)
            i = ni
            j = nj
        elif val<s:
            i+=1
        else:
            j-=1
    if s == 0:
        answer-=1
    print(answer)

if __name__ == '__main__':
    solve()