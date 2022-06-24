import sys
def usage(x):
    if x>4979900:
        return (x+2020100)//7
    elif x>29900:
        return (x+20100)//5
    elif x>200:
        return (x+100)//3
    else:
        return x//2

def fee(x):
    if x>1000000:
        return x*7-2020100
    elif x>10000:
        return x*5-20100
    elif x>100:
        return x*3-100
    else:
        return x*2

def solve():
    while True:
        A,B = map(int,sys.stdin.readline().rstrip().split())
        if A==B==0:
            break

        amount = usage(A)

        answer = 0

        s = 0
        e = amount//2
        while s<=e:
            m = (s+e)//2
            neighbor = amount-m
            feeN = fee(neighbor)
            feeM = fee(m)
            if abs(feeM-feeN) == B:
                answer = feeM
                break
            elif abs(feeM-feeN)<B:
                e = m-1
            else:
                s = m+1
        print(answer)

if __name__ == '__main__':
    solve()