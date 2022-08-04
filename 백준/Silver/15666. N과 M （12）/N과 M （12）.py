import sys

def f(g,m,l):
    if len(l) == m:
        print(" ".join(map(str,l)))
    else:
        for i in range(len(g)):
            if len(l) == 0 or g[i]>=l[-1]:
                l.append(g[i])
                f(g,m,l)
                l.pop()          

n,m = map(int,sys.stdin.readline().rstrip().split())
g = list(set(map(int,sys.stdin.readline().rstrip().split())))
g.sort()
f(g,m,[])