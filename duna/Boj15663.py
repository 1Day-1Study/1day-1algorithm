import sys
input=sys.stdin.readline

n,m=map(int,input().split())
arr=list(map(int, input().split())) 
#arr=list(set(map(int, input().split()))) #set 중복 제거
#n=len(arr)
visited=[False]*n
answer=[]
temp=[]

def dfs(depth,visited,temp):
  global answer
  if depth==m: 
    answer.append(tuple(temp.copy())) #set으로 중복 제거를 하기위해, tuple로 저장
    return

  for i in range(n):
    if not visited[i]:
      visited[i]=True
      temp.append(arr[i])
      dfs(depth+1,visited,temp)
      temp.pop()
      visited[i]=False

dfs(0,visited,temp)
answer=list(set(answer))

#print(answer)
answer.sort()
for a in answer:
  for k in a:
    print(k,end=' ')
  print()