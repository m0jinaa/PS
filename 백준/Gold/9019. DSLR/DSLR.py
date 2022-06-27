import sys
from collections import deque

def solve():
    t = int(sys.stdin.readline().rstrip())
    for _ in range(t):
        A,B = map(int,sys.stdin.readline().rstrip().split())
        q = deque()
        q.append([A,""])
        v = set()
        v.add(A)
        while q:
            now,ans = q.popleft()
            if now == B:
                print(ans)
                break
            l1 = now//1000
            l2 = now%1000
            r1 = now//10
            r2 = now%10
            #D
            temp = (now*2)%10000
            if temp not in v:
                v.add(temp)
                q.append([temp, ans+"D"])
            #S
            temp = now-1 if now != 0 else 9999
            if temp not in v:
                v.add(temp)
                q.append([temp, ans+"S"])
            #L
            temp = l2*10+l1
            if temp not in v:
                v.add(temp)
                q.append([temp, ans+"L"])
            #R
            temp = r2*1000+r1
            if temp not in v:
                v.add(temp)
                q.append([temp, ans+"R"])

if __name__ == '__main__':
    solve()