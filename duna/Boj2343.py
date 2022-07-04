n,m=map(int,input().split())
minute=list(map(int,input().split()))

def can_save(size):
  cnt=1
  temp=0
  for t in minute:
    if temp+t>size:
      temp=t
      cnt+=1
    else:
      temp+=t
    #print(i,temp,t)
  
  return cnt<=m


left=max(minute)
right=10000*n

while left<=right:
  mid=(left+right)//2
  if can_save(mid):
    ans=mid
    right=mid-1
  else:
    left=mid+1

print(ans)