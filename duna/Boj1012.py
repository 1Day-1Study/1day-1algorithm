from collections import deque
t=int(input())

drs=[-1,1,0,0]  #상하좌우
dcs=[0,0,-1,1]

def in_range(r,c):  #현재 위치가 격자 범위 내인가
  return r>=0 and r<n and c>=0 and c<m

def can_go(r,c):  #현재 위치가 범위 내이고, 배추가 존재하는가
  return in_range(r,c) and graph[r][c]==1

def bfs():
  while q:
    r,c=q.popleft()
    for dr,dc in zip(drs,dcs):
      nr,nc=dr+r,dc+c  #상하좌우 방향과 현재 위치의 더한 새로운 위치값
      if can_go(nr,nc):  #갈 수 있는곳인지
        graph[nr][nc]=0  #방문을 했다는 표시(더이상 갈수 없게 0으로 처리)
        q.append((nr,nc)) #위치값 넣기
q=deque()

for _ in range(t):
  m,n,k=map(int,input().split())
  cnt=0  #벌레 마리수

  graph=[  #배추 땅 만들기
    [0 for _ in range(m)] 
    for _ in range(n)
  ]

  for _ in range(k):  #배추가 있는곳 표시
    c,r=map(int,input().split())
    graph[r][c]=1

  for r in range(n):  #해당 땅 다 탐색(배추 좌표를 따로 저장해 놓고 진행해도 가능 )
    for c in range(m):
      if can_go(r,c):   #갈 수 있는곳인지
        q.append((r,c)) 
        graph[r][c]=0  #방문을 했다는 표시(더이상 갈수 없게 0으로 처리)
        bfs()
        cnt+=1  #벌레 마리수 
      
  print(cnt)
