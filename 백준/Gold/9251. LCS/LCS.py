import sys

s1 = list(sys.stdin.readline().rstrip())
s2 = list(sys.stdin.readline().rstrip())


g = [[0]*len(s2) for _ in range(len(s1))]

if s1[0] == s2[0]:
    g[0][0] = 1
else:
    g[0][0] = 0

for i in range(1,len(s2)):
    if s2[i] == s1[0]:
        g[0][i] = 1
    else:
        g[0][i] = g[0][i-1]

for i in range(1,len(s1)):
    if s1[i] == s2[0]:
        g[i][0] = 1
    else:
        g[i][0] = g[i-1][0]

for i in range(1,len(s1)):
    for j in range(1,len(s2)):
        if s1[i] == s2[j]:
            g[i][j] = g[i-1][j-1]+1
        else:
            g[i][j] = max(g[i-1][j],g[i][j-1])

print(g[-1][-1])
