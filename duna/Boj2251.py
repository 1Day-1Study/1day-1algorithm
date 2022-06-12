from collections import deque
limit=list(map(int,input().split()))  #물의 최대값
#a=0,b=1,c=2
visited=[  #a:200, b:200, c:200 나올수 있는 경우의 수 (각 a,b,c의 최대값으로 해도 된다.)
  [
    [False for _ in range(201)]
    for _ in range(201)
  ]
  for _ in range(201)
        ]

#answer=[] #정답 저장, 정렬 필요함
possible=[  #조건을 만족하는 값만 True 표시, 정답 저장가능, 정렬 필요 없음
  False for _ in range(201)
]

def move(cur,i,j):  #i<-j 이동
  temp=[cur[0],cur[1],cur[2]]  #이동한 위치를 저장할 임시배열, cur 배열 값이 변하면 안된다.
  
  if cur[i]+cur[j]>limit[i]:  #현재 j번째 물통이 i번째 물통으로 이동할때 i번째 물통의 한계값 보다 큰 경우
    temp[j]-=limit[i]-cur[i]  #j번째 물통에 i번째 물통의 한계값까지 담고 남은 물
    temp[i]=limit[i]  #i번째 물통에 물을 가득 채움

  else:  #현재 j번째 물통이 i번째 물통으로 이동할때 i번째 물통의 한계값 보다 작거나 같은 경우
    temp[i]+=cur[j]  #i번째 물통에 j번째 물통 물을 이동 시킴
    temp[j]=0  #j번째 물통의 물을 다 이동시킴

  return temp 

q=deque()  #큐

def bfs():
  while q:  #더이상 q에 값이 없을때까지
    cur=q.popleft()  #큐에 저장된 정점을 꺼낸다.
    if cur[0]==0:  #A가 0일때 C의 값 저장
      #answer.append(cur[2])  #직접 저장
      possible[cur[2]]=True  #해당 값 가능 표시

    for i in range(3):  #이동하는 물을 받는 물통 탐색 (i)
      for j in range(3):  #물이 이동하는 물통 탐색 (j)
        if i!=j:  #같은 물통이 아닐때
          next=move(cur,i,j)  #물을 이동시키고 나온 결과를 next에 저장
          if not visited[next[0]][next[1]][next[2]]:  #이동시킨 결과(next)가 이전에 나온적(방문한적)이 있는지 확인
            visited[next[0]][next[1]][next[2]]=True   #이동시킨 결과가 나왔다는걸(방문했다는걸) 표시
            q.append(next)  #q에 현재 위치에서 인접한(물이 이동할 수 있는 조건을) 만족하는 모든 경우)

q.append((0,0,limit[2]))  #초기값 c는 물이 최대로 채워져있다.
bfs()  #물통의 물을 이동시킬 수 있는 모든 경우의 수를 찾는다.

for i in range(201):
  if possible[i]:
    print(i,end=' ')