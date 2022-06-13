import sys

def solve():
    m,n,l = map(int,sys.stdin.readline().rstrip().split())
    pos = list(map(int,sys.stdin.readline().rstrip().split()))
    animal = [list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(n)]

    pos.sort()
    answer = 0
    for x,y in animal:
        s = 0
        e = m-1
        while s<e:
            mid = (s+e)//2
            if pos[mid]<x:
                s = mid+1
            else:
                e = mid
        if abs(x-pos[e])+y<=l or abs(x-pos[e-1])+y<=l:
            answer+=1
    print(answer)

if __name__ == '__main__':
    solve()