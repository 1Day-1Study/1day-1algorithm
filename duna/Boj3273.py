n=int(input())
arr=list(map(int,input().split())) 
x=int(input())  #두수의 합
checked=[False for _ in range(n)]  #방문 체크

def is_sum_num(p):
  left,right=0,n-1
  target=arr[p]
  while left<=right:
    mid=(left+right)//2

    if not checked[mid] and arr[mid]+target==x:  
      #전에 target으로 사용한 수인지, 2+3, 3+2로 중복 안되게 하기 위해
      #현재 target과 같은 수가 아닌지
      return True 
    
    elif arr[mid]+target>x:
      right=mid-1

    else:
      left=mid+1

  return False

cnt=0
arr.sort()

for i in range(n):
  checked[i]=True
  if is_sum_num(i):  #만족하면 카운트 해줌
    cnt+=1

print(cnt)