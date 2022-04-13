import sys
from collections import deque

input=sys.stdin.readline

n,k=map(int,input().split())

que=deque() 
#멀티 스레드를 이용해 데이터가 많을때는 기존 stack을 이용하는것보다 빠름

for i in range(1,n+1):
  que.append(i)

print('<',end='')

while que:
  if len(que)==1:
    print("{0}>".format(que.popleft()))
    break

  que.rotate(-(k-1)) #왼쪽 방향으로 k-1번 회전
  print("{0}, ".format(que.popleft()),end='') #k번째 수
    