import sys
from collections import deque

input=sys.stdin.readline

deque=deque()

n=int(input())

for _ in range(n):
  command=input().strip()
  if command =='pop_front':
    if deque:
      print(deque.popleft()) #왼쪽 pop
    else:
      print(-1)

  elif command == 'pop_back':
    if deque:
      print(deque.pop()) #오른쪽 pop
    else:
      print(-1)

  elif command == 'size':
    print(len(deque))

  elif command == 'empty':
    if deque:
      print(0)
    else:
      print(1)

  elif command == 'front':
    if deque:
      print(deque[0])
    else:
      print(-1)

  elif command == 'back':
    if deque:
      print(deque[-1]) #마지막 원소 
    else:
      print(-1)

  else:
    c,v = command.split()
    if c == 'push_front':
      deque.appendleft(v) #왼쪽 추가
    else:
      deque.append(v) #오른쪽 추가