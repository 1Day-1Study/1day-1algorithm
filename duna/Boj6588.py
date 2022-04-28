import sys
import math

input=sys.stdin.readline

prime=[False,False]+[True]*1000000

for i in range(2,int(math.sqrt(1000000)+1)):
  if prime[i]:
    for j in range(i*2,1000000,i):
      prime[j]=False
  
while True:
  n=int(input().strip())
  if n==0:
    break
  for i in range(2,n):
    if prime[i] and prime[n-i]: #소수의 서로 합이 나오는 수 출력
        print("{0} = {1} + {2}".format(n,i,n-i))
        break
  else: #break를 빠져나가는지 아닌지
    print("Goldbach's conjecture is wrong.")