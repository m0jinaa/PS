import sys

def solve():
    n,c = map(int,sys.stdin.readline().rstrip().split())

    obj = list(map(int,sys.stdin.readline().rstrip().split()))
    obj.sort()

    if c in obj:
        print(1)
    else:
# 2개
        s = 0
        e = n-1
        while s<e:
            v = obj[s]+obj[e]
            if v == c:
                print(1)
                exit()
            elif v < c:
                s+=1
            else:
                e-=1

#3개
        for i in range(n-2):
            if obj[i]>c:
                break
            s = i+1
            e = n-1
            while s<=e:
                v = obj[i]+obj[s]+obj[e]
                if v == c:
                    print(1)
                    exit()
                elif v<c:
                    s+=1
                else:
                    e-=1
        print(0)

if __name__ == '__main__':
    solve()