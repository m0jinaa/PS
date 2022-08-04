def chose(g,n,m):
    if len(g) == m:
        for t in g:
            print(t,end=" ")
        print()
    else:
        if len(g)>=1:
            for i in range(max(g),n+1):
                g.append(i)
                chose(g,n,m)
                g.pop()
        else:
            for i in range(1,n+1):
                g.append(i)
                chose(g,n,m)
                g.pop()

n,m = map(int,input().split())
graph = []
chose(graph,n,m)