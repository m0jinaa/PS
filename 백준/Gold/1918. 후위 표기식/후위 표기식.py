import sys

g = list(sys.stdin.readline().rstrip())
stack = []
answer = []

for i in g:
    if 65<=ord(i)<=90:
        answer.append(i)
    else:
        if i == "(":
            stack.append(i)
        elif i == "*" or i == "/":
            while stack and (stack[-1] == "*" or stack[-1]=="/"):
                answer.append(stack.pop())
            stack.append(i)
        elif i == "+" or i == '-':
            while stack and stack[-1] != '(':
                answer.append(stack.pop())
            stack.append(i)
        elif i == ")":
            while stack and stack[-1] != "(":
                answer.append(stack.pop())
            stack.pop()
while stack:
    answer.append(stack.pop())

print("".join(answer))