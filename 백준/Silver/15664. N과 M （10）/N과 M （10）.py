import sys

def f(g,m,l,d):
    if len(l) == m:
        try:
            if d["".join(map(str,l))] == 1:
                pass
        except:
            d["".join(map(str,l))] = 1
            print(" ".join(map(str,l)))
    else:
        for i in range(len(g)):
            if len(l) == 0:
                v[i] = 1
                l.append(g[i])
                f(g,m,l,d)
                v[i] = 0
                l.pop()
            else:
                if v[i] == 0 and l[-1] <= g[i]:
                    v[i] = 1
                    l.append(g[i])
                    f(g,m,l,d)
                    v[i] = 0
                    l.pop()
        
n,m = map(int,sys.stdin.readline().rstrip().split())
g = list(map(int,sys.stdin.readline().rstrip().split()))
g.sort()
d = {}
v = [0]*n
f(g,m,[],d)