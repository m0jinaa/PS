import sys

def solve():
    n = int(sys.stdin.readline().rstrip())
    liquid = list(map(int,sys.stdin.readline().rstrip().split()))
    liquid.sort()
    val = sys.maxsize
    answer = []
    for i in range(n-2):
        l = i+1
        r = n-1
        while l<r:
            v = liquid[i]+liquid[l]+liquid[r]
            if abs(v)<val:
                val = abs(v)
                answer = [liquid[i],liquid[l],liquid[r]]
            if v<0:
                l+=1
            elif v>0:
                r-=1
            else:
                break
    print(*answer)


if __name__ == '__main__':
    solve()