import sys
input=sys.stdin.readline
n=int(input())
dic={}
for _ in range(n):
  file, extend =input().strip().split('.')
  dic[extend]=dic.get(extend,0)+1 #key=extend인 값이 있으면 반환, 없으면 0반환, 해당 extend가 생기면 +1을 해준다.

answer=sorted(dic.items())  #딕셔너리에 key value를 이용해 정렬

for i in range(len(answer)):
  print(answer[i][0],answer[i][1])