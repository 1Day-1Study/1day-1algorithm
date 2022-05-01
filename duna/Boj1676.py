import sys

n=int(sys.stdin.readline())

num=1
cnt=0

for i in range(2,n+1):
  num*=i

while num>0:
  if num%10!=0: # 뒤의 수가 0이 나오지 않을때
    break;
  num//=10 #실수가 아닌 정수가 저장되게 하기 위해 
  cnt+=1 #0의 개수

print(cnt)