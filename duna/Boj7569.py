from collections import deque
#며칠후, 토마토가 다익어, 최소 일수
#1 익은 토마토, 0 익지않은 토마토, -1 비어있음
#처음 부터 모든 토마토 익어있다. 0, 모두 익지 못하면 -1
m,n,h=map(int,input().split())  #m 가로, n 세로, h 높이(상자의 수)
tomato=[
  [list(map(int,input().split())) for _ in range(n)]
  for _ in range(h)
]

day=[
  [
    [0 for _ in range(m)]
    for _ in range(n) 
  ]
  for _ in range(h)
]

dzs=[-1,1,0,0,0,0] #위,아래,왼쪽,오른쪽,앞,뒤
drs=[0,0,0,0,1,-1]
dcs=[0,0,-1,1,0,0]

def in_range(z,r,c):
  return z>=0 and z<h and r>=0 and r<n and c>=0 and c<m

def can_go(z,r,c):
  return in_range(z,r,c) and tomato[z][r][c]==0

def set_value(z,r,c,value):
  tomato[z][r][c]=1
  day[z][r][c]=value
  q.append((z,r,c))

def answer():
  cnt=0
  for k in range(h):
    for i in range(n):
      for j in range(m):
        if tomato[k][i][j]==0:  #안익은 토마토
          return -1
          
        cnt=max(cnt,day[k][i][j])
        
  return cnt 
  
def bfs():
  while q:
    z,r,c=q.popleft()
    for dz,dr,dc in zip(dzs,drs,dcs):
      nz,nr,nc=dz+z,dr+r,dc+c
      if can_go(nz,nr,nc):
        set_value(nz,nr,nc,day[z][r][c]+1)

q=deque()

#익은 토마토 찾기
for k in range(h):
  for i in range(n):
    for j in range(m):
      if tomato[k][i][j]==1:  #익은 토마토
        set_value(k,i,j,0)
 
bfs()
print(answer())


#print(*day)
#print(*tomato)
