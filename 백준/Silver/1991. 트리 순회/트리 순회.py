import sys

def preorder(i):
    print(i,end="")
    for j in d[i]:
        if j != '.':
            preorder(j)

def inorder(i):
    if d[i][0] != '.':
        inorder(d[i][0])
    print(i,end="")
    if d[i][1] != '.':
        inorder(d[i][1])

def postorder(i):
    for j in d[i]:
        if j != '.':
            postorder(j)
    print(i,end="")

d = {}

n = int(sys.stdin.readline().rstrip())

for _ in range(n):
    a,b,c = sys.stdin.readline().rstrip().split()

    d[a] = [b,c]

preorder('A')
print()
inorder('A')
print()
postorder('A')
print()