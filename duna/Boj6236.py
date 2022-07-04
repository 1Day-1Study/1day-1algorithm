n,m=map(int,input().split())
money=[
  int(input()) for _ in range(n)
]

def can_money(value):
  cnt=1
  temp=0
  for coin in money:
    if temp+coin>value:
      temp=coin
      cnt+=1
    else:
      temp+=coin
  
  return cnt<=m

left=max(money)
right=10000*n

while left<=right:
  mid=(left+right)//2
  if can_money(mid):
    ans=mid
    right=mid-1
  else:
    left=mid+1
  #print(mid,left,right)
print(ans)