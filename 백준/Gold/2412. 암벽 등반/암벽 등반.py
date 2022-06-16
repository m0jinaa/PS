import sys
from collections import deque

def solve():
    n,t = map(int,sys.stdin.readline().rstrip().split())

    po = set([tuple(map(int,sys.stdin.readline().rstrip().split())) for _ in range(n)])
    q = deque()
    q.append([0,0,0])
    inf = sys.maxsize
    answer = -1
    while q:
        a,b,c = q.popleft()
        if b == t:
            answer = c
            break

        for i in range(-2,3):
            for j in range(-2,3):
                x = a+i
                y = b+j
                if (x,y) in po:
                    q.append([x,y,c+1])
                    po.remove((x,y))
    print(answer)


if __name__ == '__main__':
    solve()