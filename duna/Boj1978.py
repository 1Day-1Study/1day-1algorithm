import sys
import math

input=sys.stdin.readline
prime=int(input()) #소수 개수
num=list(map(int,input().split()))

for n in num:
  if n==1:
    prime-=1
  for i in range(2,int(math.sqrt(n))+1): #절반까지만 세도록 제곱근을 사용
    if n%i==0:
      prime-=1 #소수가 아니니까 값을 빼줌
      break
print(prime)