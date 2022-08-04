import sys

def getm(g,m,l):
    if len(l) == m:
        print(" ".join(map(str,l)))
    else:
        for i in g:
            if i not in l:
                l.append(i)
                getm(g,m,l)
                l.pop()

n,m = map(int,sys.stdin.readline().rstrip().split())
g = list(map(int,sys.stdin.readline().rstrip().split()))

g.sort()

getm(g,m,[])