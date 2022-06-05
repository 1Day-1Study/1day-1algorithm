n=int(input())
a=list(map(int,input().split()))
m=int(input())
arr=list(map(int,input().split()))

def num_search(target):  #숫자가 있는지 탐색
  left,right=0,n-1
  
  while left<=right:
    mid=(left+right)//2

    if a[mid]==target:  #같은 수가 있다.
      return True

    elif a[mid]>target:
      right=mid-1

    else:
      left=mid+1

  return False
  
a.sort()

for num in arr:
  if num_search(num):  #숫자가 있으면 True, 없으면 False
    print(1)

  else:
    print(0)