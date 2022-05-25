import sys
k,n=map(int,input().split())  #이미 가지고 있는 k, 필요한 n
lan=[int(input()) for _ in range(k)]

def is_valid(cm):   #해당값 나눈 길이 계수 n 이상인지 판단
  cnt=0
  for i in range(k):
    if lan[i]>=cm:
      cnt+=lan[i]//cm
  
  return cnt>=n
   

left=1
#right=2147483647  #2^31-1, 최대값
right=max(lan)
answer=0

while left<=right:
  mid=(left+right)//2

  if is_valid(mid):
    answer=mid
    left=mid+1

  else:
    right=mid-1

print(answer)