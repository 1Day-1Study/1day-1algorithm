n=int(input())
arr=list(map(int,input().split()))
check=[False for _ in range(100000+1)]

start=0
cnt=0

for end in range(n):
  
  while check[arr[end]]:
    check[arr[start]]=False
    start+=1

  check[arr[end]]=True
  cnt+=end-start+1

print(cnt)