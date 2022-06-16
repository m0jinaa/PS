import sys

def solve():
    n = int(sys.stdin.readline().rstrip())
    h = list(map(int,sys.stdin.readline().rstrip().split()))
    h.sort()
    answer = sys.maxsize
    for i in range(n):
        for j in range(i+2,n):
            l = i+1
            r = j-1
            while l<r:
                val = (h[i]+h[j])-(h[l]+h[r])
                if val == 0:
                    print(0)
                    exit()
                if abs(val)<answer:
                    answer = abs(val)
                if val<0:
                    r-=1
                else:
                    l+=1
    print(answer)

if __name__ == '__main__':
    solve()