import sys

input=sys.stdin.readline

n=int(input())
que =[] #stack 사용

for _ in range(n):
  command=input().strip()

  if command == 'pop':
    if que:
      print(que.pop(0)) #맨앞의 원소를 뺀것
    else:
      print(-1)

  elif command == 'size':
    print(len(que))
    
  elif command == 'empty':
    if que:
      print(0)
    else:
      print(1)

  elif command == 'front':
    if que:
      print(que[0])
    else:
      print(-1)

  elif command == 'back':
    if que:
      print(que[-1])
    else:
      print(-1)

  else:
    c,value =command.split()
    que.append(value)