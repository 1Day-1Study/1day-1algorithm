n=int(input())
m=int(input())
position=list(map(int,input().split()))

def can_len(len):
  l=0
  for p in position:
    if l<p-len:
      return False
    l=p+len
  return l>=n

left=0
right=100000

while left<=right:
  mid=(left+right)//2
  if can_len(mid):
    ans=mid
    right=mid-1
  
  else:
   left=mid+1 

print(ans)