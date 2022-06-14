import sys

def solve():
    r,c = map(int,sys.stdin.readline().rstrip().split())
    table = ["" for _ in range(c)]
    for i in range(r):
        l = list(sys.stdin.readline().rstrip())
        for j in range(c):
            table[j]+=l[j]

    s = 0
    e = r-1
    answer = 0
    while s<=e:
        m = (s+e)//2
        t = set()
        for i in table:
            t.add(i[m:])
        if len(t) == c:
            answer = m
            s = m+1
        else:
            e = m-1
    print(answer)

if __name__ == '__main__':
    solve()