import sys

def solve():
    n = int(sys.stdin.readline().rstrip())
    a = list(map(int,sys.stdin.readline().rstrip().split()))

    a.sort()
    answer = 0
    for i in range(n-2):
        s = i+1
        e = n-1
        while s<e:
            val = a[i]+a[s]+a[e]
            if val == 0:
                if a[s] == a[e]:
                    t = e-s+1
                    answer+= t*(t-1)//2
                    break
                else:
                    ns = s+1
                    ne = e-1
                    while ns<n and a[ns]==a[s]:
                        ns+=1
                    while ne>=0 and a[ne]==a[e]:
                        ne-=1
                    answer+=(ns-s)*(e-ne)
                    s = ns
                    e = ne
            elif val<0:
                s+=1
            else:
                e-=1
    print(answer)

if __name__ == '__main__':
    solve()