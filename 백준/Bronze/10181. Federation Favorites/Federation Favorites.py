import sys

while True:
    n = int(sys.stdin.readline().rstrip())
    if n == -1:
        break
    m = set()
    m.add(1)
    for i in range(2,n//2):
        if n%i == 0:
            m.add(i)
            if i*i != n:
                m.add(n//i)
    measure = list(m)
    if sum(measure) == n:
        measure.sort()
        print("%d =" %n, " + ".join(map(str,measure)))
    else:
        print("%d is NOT perfect." %n)