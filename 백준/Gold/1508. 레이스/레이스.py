import sys

def solve():
    n,m,k = map(int,sys.stdin.readline().rstrip().split())
    spot = list(map(int,sys.stdin.readline().rstrip().split()))
    spot.sort()
    dist = [spot[i]-spot[i-1] for i in range(1,k)]

    s = 1
    e = int(1e6)
    answer = ""

    while s<=e:
        mid = (s+e)//2
        cnt = 1
        ans = '1'
        s = 0
        for i in dist:
            if cnt == m:
                break
            s+=i
            if s>=mid:
                cnt+=1
                s = 0
                ans+='1'
            else:
                ans+='0'
        for _ in range(len(spot)-len(ans)):
            ans+='0'
        if cnt<m:
            e = mid-1
        else:
            answer = ans
            s = mid+1
    print(answer)

if __name__ == '__main__':
    solve()