import sys
input = sys.stdin.readline
N=int(input())
stack=[]
top=0
for _ in range(N):
  w = input().strip() 

  if w == 'pop':
    if top != 0:
      print(stack.pop())
      top-=1
    else:
      print(-1)
      
  elif w == 'size':
    print(top)
    
  elif w == 'empty':
    print(1 if top==0 else 0 )
    
  elif w == 'top':
    print(stack[-1] if top!=0 else -1)

  else:
    stack.append(w.split()[1])
    top+=1

