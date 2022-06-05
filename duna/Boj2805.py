n,m=map(int,input().split())
tree=list(map(int,input().split()))

def is_valid(tree_m):
  cnt=0
  for t in tree:
    if tree_m<=t:  #tree_m이 나무 길이(t)보다 작아야 자를수 있으니
      cnt+=t-tree_m  #자른 나무 합

  return cnt>=m  #필요한 길이 이상일때 true
  
left=0
right=max(tree)
answer=0

while left<=right:
  mid=(left+right)//2

  if is_valid(mid):  #만족하면 answer에 값 저장
    answer=mid
    left=mid+1

  else:  #자르 위치가 너무 커 만족하는 m이 안나올때
    right=mid-1

print(answer)