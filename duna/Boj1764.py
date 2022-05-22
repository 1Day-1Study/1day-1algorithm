import sys
input=sys.stdin.readline
n,m=tuple(map(int,input().split()))
listen={input().strip(): True for _ in range(n)} #듣도
look=[input().strip() for _ in range(m)]  #보도
answer=[]  #답
cnt=0  #전체 개수

for l in look:
    if listen.get(l,False):  #딕셔너리 내에 해당 key가 있으면 True, 없으면 False
      cnt+=1
      answer.append(l)

answer.sort()  #사전순 정렬
print(cnt)  #총 개수
for a in answer:
  print(a)  #듣보잡 수