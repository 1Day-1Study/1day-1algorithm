import sys
input=sys.stdin.readline

n=int(input())
A=list(map(int,input().split()))

answer=[-1]*n #해당 인덱스 값에 바로 값을 넣어주기 위해
arr=[]

for i in range(n):
  arr.append((i,A[i])) #tuple로 A의 index값과, 해당 A의 값 

arr.sort(key=lambda x:x[1]) #A의 값만 정렬, 비순차적으로 정렬됨, 동일한 값일 경우 처음 들어온 값이 앞으로 가게 된다.

for i in range(n):
  answer[arr[i][0]]=i  #정렬된 A의 index값을 answer index에 arr의 index값을 넣는다. 

print(' '.join(map(str,answer)))