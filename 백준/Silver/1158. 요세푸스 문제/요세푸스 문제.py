n,k = map(int,input().split())
arr = [i for i in range(1,n+1)]

answer = []
p = 0
while len(arr):
    p = (p+k-1)%len(arr)
    answer.append(str(arr.pop(p)))
    
print("<"+", ".join(answer)+">")