import sys

input=sys.stdin.readline

n,length=map(int,input().split())
arr=list(input().split())
arr.sort()
visited=[False]*length
password=[]
vowel=['a','e','i','o','u']  #모음
#password.append(arr[1])

def dfs(depth,visited,k,vowel_cnt):
  global password

  if vowel_cnt>n-2: #자음 개수가 2보다 작을때
    return
    
  if depth==n and vowel_cnt>=1: #모음이 최소 1개 이상
    print(''.join(password))
    return


  for i in range(k,length):
    if not visited[i]:
      visited[i]=True
      password.append(arr[i])
      if arr[i] in vowel: #모음 계수
        dfs(depth+1,visited,i+1,vowel_cnt+1)
      else:
        dfs(depth+1,visited,i+1,vowel_cnt) #사전순으로 하기 위해 앞에 보다 뒤쪽 부터 탐색
      
      visited[i]=False
      password.pop()
      
    
dfs(0,visited,0,0)