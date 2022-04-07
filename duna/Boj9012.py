import sys
input=sys.stdin.readline

n=int(input())
for _ in range(n):
  stack=[]
  arr=input().strip()
  if arr[0]==')' or arr[-1]=='(':
    print("NO")
  else:
    stack.append(arr[0])
  
    for i in range(1,len(arr)):
      #print("stack=",stack)
      if len(stack)==0 and arr[i]==')':
        stack.append(-1)
        break;
      elif len(stack)>0 and stack[-1] != arr[i]:
        stack.pop()
      else:
        stack.append(arr[i])

    print("YES" if len(stack)==0 else "NO")