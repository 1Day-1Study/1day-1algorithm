n=int(input())
node=[[] for i in range(n)]
visited=[False]*n

def dfs(cur):
  global cnt
  
  if not node[cur] or node[cur]==[remove]:
    #print('c:',cur)
    cnt+=1
    return 

  for i in node[cur]:
    if not visited[i]:
      visited[i]=True
      dfs(i)
      visited[i]=False

for i,j in enumerate(map(int,input().split())):
  if j==-1:
    start=i
  else:
    node[j].append(i)

remove=int(input())

visited[remove]=True

cnt=0

if not visited[start]:
  visited[start]=True
  dfs(start)

#print(*visited)
#print(*node)
print(cnt)