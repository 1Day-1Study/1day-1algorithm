import sys
input=sys.stdin.readline

n,s=map(int,input().split())
arr=list(map(int,input().split()))
visited=[False]*n

cnt=0

def dfs(depth,sum):
  global cnt
    
  if depth==n:  #다 탐색시
    if sum==s: #수가 만족
      cnt+=1
    return 
  
  dfs(depth+1,sum) #더하지 않을때
  dfs(depth+1,arr[depth]+sum)  #더할 때

dfs(0,0)

if s==0:
  cnt-=1
print(cnt)

'''
5 0
0 0 0 0 0
에서 중간에 값이 충족하다고 종료 시키면 이 경우 값이 다 나오지 않는다.
'''