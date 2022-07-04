from collections import deque
com_num=int(input()) #컴 수
n=int(input())
graph=[
  [0 for _ in range(com_num+1)]
  for _ in range(com_num+1)
]

visited=[
  False for _ in range(com_num+1)
]

def bfs():
  global cnt
  while q:
    cur=q.popleft()
    cnt+=1 #컴 개수 카운트
  
    for next in range(2,com_num+1):
      if graph[cur][next]==1 and not visited[next]:
        visited[next]=True
        q.append(next)
    
q=deque()
cnt=0

for _ in range(n):  #인접 행렬
  start,end=map(int,input().split())
  graph[start][end]=1
  graph[end][start]=1

q.append(1)
bfs()
print(cnt-1)  #1번 컴 제외