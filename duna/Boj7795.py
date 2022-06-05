import sys
input=sys.stdin.readline

def binary_search (arr,target,left):
  
  right=len(arr)-1
  
  while left <= right:
    mid = (left + right) // 2

    if arr[mid] > target: #mid가 target보다 큰수
      if arr[left]>target:
        return left
      else:
        left += 1
        
    elif arr[mid] <= target: #mid가 target보다 같거나 작은수
      left = mid + 1
      
  return -1
  
test=int(input())

for _ in range(test):
  n,m=map(int,input().split())
  arr1=list(map(int,input().split()))
  arr2=list(map(int,input().split()))

  arr1.sort()
  arr2.sort()

  left=0
  answer=0
  
  for target in arr2:
    left=binary_search(arr1,target,left) #다음 arr2의 수는 크거나 같으니까
    if left==-1: #arr1이 더이상 arr2의 물고기를 잡아 먹을수 없다.
      break
    answer+=(len(arr1)-left)  #잡아 먹을수 있는 물고기

  print(answer)