import sys

input=sys.stdin.readline

n,m=map(int,input().split())
#visited=[False]*(n+1)
arr=[-1]*m
#print(arr)
def dfs(n,m,depth,k):

  if depth==m:
    print(' '.join(map(str,arr)))
    return 

  
  for i in range(k,n+1):
    #if not visited[i]:
      #visited[i]=True
    arr[depth]=i
    #print(arr,depth, i)
    dfs(n,m,depth+1,i)
      #visited[i]=False

dfs(n,m,0,1)

