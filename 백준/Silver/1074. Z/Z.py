import sys
from collections import deque


def z(x,y,l,a,b):
    if a in range(x,x+l) and b in range(y,y+l):
        if l == 2:
            p[0] = 1

            return (a-x)*2+b-y+1
        elif p[0] == 0:
            d = l//2
            dx = [0,0,d,d]
            dy = [0,d,0,d]
            ans = 0
            for i in range(4):
                ans+=z(x+dx[i],y+dy[i],d,a,b)
        return ans
    else:
        if (x<=a or y<=b) and(x+l-1<a or y+l-1<b) and p[0] == 0:

            return l*l
    return 0

n,r,c = map(int,input().split())
p = [0]
print(z(0,0,pow(2,n),r,c)-1)