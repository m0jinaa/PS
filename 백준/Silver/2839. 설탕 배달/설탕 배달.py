w = int(input())
m = w//5
c = 5000
p = 0
if w%5 == 0: # when perfectly divided by 5
    print(m)
else: # when there are remains
    for i in range(m,-1,-1):
        r = w-5*i
        if r%3 == 0:
            print(i+(r//3))
            p = 1
            break
        
    if p == 0:
        print(-1)