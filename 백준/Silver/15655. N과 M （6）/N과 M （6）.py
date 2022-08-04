import sys

def getm(g,m,l):
    if len(l) == m:
        print(" ".join(map(str,l)))
    else:
        for i in g:
            if len(l):
                if i >l[-1]:
                    l.append(i)
                    getm(g,m,l)
                    l.pop()
            else:
                l.append(i)
                getm(g,m,l)
                l.pop()
                
n,m = map(int,sys.stdin.readline().rstrip().split())
g = list(map(int,sys.stdin.readline().rstrip().split()))

g.sort()

getm(g,m,[])