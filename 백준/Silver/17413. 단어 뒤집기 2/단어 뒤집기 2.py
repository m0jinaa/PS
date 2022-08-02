import sys
s = list(sys.stdin.readline().rstrip())

c = 0
g= []
for i in s:
    if i == "<":
        if len(g):
            print("".join(reversed(g)),end="")
            g.clear()
        c = 1
        g.append(i)
    elif i == ">":
        g.append(i)
        print("".join(g),end="")
        g.clear()
        c = 0
    elif c == 1:
        g.append(i)
    elif c == 0:
        if i == " ":
            print("".join(reversed(g)),end="")
            print(" ",end="")
            g.clear()
        else:
            g.append(i)
if c == 0:
    print("".join(reversed(g)))
else:
    print("".join(g))