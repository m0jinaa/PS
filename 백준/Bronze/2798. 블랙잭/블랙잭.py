n,m = map(int,input().split())
arr = list(map(int,input().split()))
arr.sort()
answer = 0
dif = 300000
d = 0
for i in range(n):
    for j in range(i+1,n):
        for k in range(j+1,n):
            v = arr[i]+arr[j]+arr[k]
            d = m-v
            if d<0:
                break
            if d < dif:
                answer = v
                dif = d
            
print(answer)
