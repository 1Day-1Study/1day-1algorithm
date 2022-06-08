n,k=map(int,input().split())
arr=list(map(int,input().split()))
right=0
ans=n+1  # 만족하는 수열이 없을 수도 있다.
cnt=0   # 라이언 인형 개수 

for left in range(n):
  if arr[left]==1:  #라이언 인형 카운트
    cnt+=1
    if cnt==1:  #라이언 인형이 처음으로 나옴
      right=left

  if cnt==k:
    ans=min(ans,left-right+1)  #인형 개수의 합의 최소
    while left!=n-1:
      right+=1
      if arr[right]==1:  #다음 라이언 인형 
        cnt-=1  #이전 라이언 인형
        break

print(ans if ans<n+1 else -1)
    
#각 개수 더해주기, 라이언이 k개가 되면 right로 개수 빼주기
#라이언 1, 어피치 2
#만족하지 않는 수열 -1
