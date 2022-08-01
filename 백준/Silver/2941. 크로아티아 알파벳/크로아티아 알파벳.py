import sys

s = sys.stdin.readline().rstrip()
n = len(s)
cnt=0
i = 0
while i<n:
    cnt+=1
    if i==n-1:
        break
    else:
        if s[i] == "c":
            if s[i+1] in ["=","-"]:
                i +=1
        elif s[i] == "d":
            if s[i+1] == "-":
                i +=1
            elif i<n-2:
                if s[i+1] == "z" and s[i+2] == "=":
                    i +=2
        elif s[i] == "l":
            if s[i+1] == "j":
                i +=1
        elif s[i] == "n":
            if s[i+1] == "j":
                i +=1
        elif s[i] == "s":
            if s[i+1] == "=":
                i +=1
        elif s[i] == "z":
            if s[i+1] == "=":
                i +=1
    i+=1
print(cnt)