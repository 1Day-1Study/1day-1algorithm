n,k=map(int,input().split())
alcohol=[
  int(input()) for _ in range(n)
]


def can_drink(i):
  cnt=0
  for a in alcohol:
    cnt+=a//i
    #print(a,i)
  
  return cnt>=k

left=1
right=max(alcohol)

while left<=right:
  mid=(left+right)//2
  if can_drink(mid):
    ans=mid
    left=mid+1
  else:
    right=mid-1

print(ans)