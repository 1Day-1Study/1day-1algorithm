import sys
input=sys.stdin.readline

f_stack=list(input().strip())
b_stack=[]

n=int(input().strip())

for _ in range(n):
  command=input().strip();

  if command=='L':
    if f_stack: #비어 있지 않을때
      b_stack.append(f_stack.pop())
      
  elif command=='D':
    if b_stack: #비어 있지 않을때
      f_stack.append(b_stack.pop())
      
  elif command=='B':
    if f_stack: #비어 있지 않을때
      f_stack.pop()

  else:
    c,value=command.split()
    f_stack.append(value)

print(''.join(f_stack+b_stack[::-1])) #뒤에서 부터 출력