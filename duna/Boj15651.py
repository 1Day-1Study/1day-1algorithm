import sys

input=sys.stdin.readline

n,m=map(int,input().split())
#visited=[False]*(n+1)
arr=[-1]*m

def dfs(n,m,depth):

  if depth==m:
    print(' '.join(map(str,arr)))
    return 

  
  for i in range(1,n+1):
    #if not visited[i]:
    #visited[i]=True
    arr[depth]=i
    dfs(n,m,depth+1)


dfs(n,m,0)