def chose(g,n,m):
    if len(g) == m:
        for t in g:
            print(t,end=" ")
        print()
    else:
        for i in range(1,n+1):
            if i not in g:
                g.append(i)
                chose(g,n,m)
                g.pop()

n,m = map(int,input().split())
graph = []
chose(graph,n,m)