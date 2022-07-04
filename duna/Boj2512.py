n=int(input())
money=list(map(int,input().split()))
total=int(input())

left=1
right=max(money)

def can_money(i):
  temp=0
  for m in money:
    temp+=min(i,m)
  return temp<=total

while left<=right:
  mid=(left+right)//2
  
  if can_money(mid):
    ans=mid
    left=mid+1
  else:
    right=mid-1

  #print(mid,left,right)
print(ans)