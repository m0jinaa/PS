import sys

def make_n(n,k):
    if k <0:
        return
    elif k == 0:
        answer[n] +=1
    else:
        make_n(n,k-1)
        make_n(n,k-2)
        make_n(n,k-3)
m = int(input())
answer = [0 for _ in range(m)]

for i in range(m):
    p = int(input())
    make_n(i,p)

for a in answer:
    print(a)
