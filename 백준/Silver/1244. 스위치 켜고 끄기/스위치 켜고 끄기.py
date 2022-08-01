import sys
n = int(input())
s = list(map(int,sys.stdin.readline().rstrip().split()))
s = [0]+s
k = int(input())
for _ in range(k):
    sex,num = map(int,sys.stdin.readline().rstrip().split())

    if sex ==1:
        for i in range(num,n+1,num):
            s[i] = (s[i]+1)%2
    else:
        s[num] = (s[num]+1)%2
        for i in range(1,num):
            if i+num in range(1,n+1) and num-i in range(1,n+1):
                if s[num+i] == s[num-i]:
                    s[num+i] = (s[num+i]+1)%2
                    s[num-i] = (s[num-i]+1)%2
                else:
                    break
            else:
                break
for i in range(n//20+1):
    if i == n//20:
        print(" ".join(map(str,s[1+i*20:])))
    else:
        print(" ".join(map(str,s[1+i*20:21+i*20])))
