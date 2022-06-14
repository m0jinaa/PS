import sys

def solve():
    t = int(sys.stdin.readline().rstrip())
    for _ in range(t):
        k,n = map(int,sys.stdin.readline().rstrip().split())
        A = list(map(int,sys.stdin.readline().rstrip().split()))
        B = list(map(int,sys.stdin.readline().rstrip().split()))
        C = list(map(int,sys.stdin.readline().rstrip().split()))
        D = list(map(int,sys.stdin.readline().rstrip().split()))

        AB = []
        CD = []
        for i in A:
            for j in B:
                AB.append(i+j)
        for i in C:
            for j in D:
                CD.append(i+j)
        CD.sort()
        answer = 0
        r = sys.maxsize
        for x in AB:
            s = 0
            e = len(CD)-1
            while s<=e:
                m = (s+e)//2
                val = CD[m]+x-k
                if val == 0:
                    answer = k
                    break
                if abs(val) == r and val<0:
                    answer = val+k
                elif abs(val) <r:
                    r = abs(val)
                    answer = val+k
                if val<0:
                    s = m+1
                else:
                    e = m-1
            if answer == k:
                break
        print(answer)

if __name__ == '__main__':
    solve()