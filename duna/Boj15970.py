import sys
input=sys.stdin.readline
n=int(input())
line={}
answer=0

for _ in range(n):
  dot,color=map(int,input().split())
  line[color]=line.get(color,[])+[dot]

#print(line)
for c in line:
  arr=sorted(line[c])
  #print(arr)
  answer+=arr[1]-arr[0]  #처음
  
  for i in range(1,len(arr)-1):
    if arr[i+1]-arr[i]< arr[i]-arr[i-1]:  #이전 길이 보다 작은 길이 일때
      answer+=arr[i+1]-arr[i]

    else:
      answer+=arr[i]-arr[i-1]

    #print(i,answer)
  answer+=(arr[-1]-arr[-2])  #마지막 값
  #print(c,answer)
print(answer)