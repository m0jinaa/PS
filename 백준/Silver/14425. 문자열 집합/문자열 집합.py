import sys

n,m = map(int,sys.stdin.readline().rstrip().split())

s = {}
answer = 0
for _ in range(n):
    a = sys.stdin.readline().rstrip()

    s[a] = 1

for _ in range(m):
    b = sys.stdin.readline().rstrip()

    try:
        if s[b] == 1:
            answer+=1
    except:
        pass
print(answer)