import sys
cnt = int(sys.stdin.readline().rstrip())
dots = []
p = [0,0]
for _ in range(6):
    a,b = map(int,sys.stdin.readline().rstrip().split())

    if a == 1:
        p[0]+=b
    elif a == 2:
        p[0]-=b
    elif a ==3:
        p[1]-=b
    else:
        p[1]+=b
    dots.append(p.copy())

s = 0
f = dots[0]
bef = dots[0]
for i in range(1,6):
    s+=bef[0]*dots[i][1]
    s-=bef[1]*dots[i][0]
    if i == 5:
        s+=dots[i][0]*f[1]
        s-=dots[i][1]*f[0]
    bef = dots[i]
print(cnt*s//2)