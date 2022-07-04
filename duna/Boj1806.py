n,s=map(int,input().split())
arr=list(map(int,input().split()))

start=0
sum_v=0
ans=100001

for end in range(n):
  sum_v+=arr[end]
  if sum_v>=s:
    while sum_v>=s:
      sum_v-=arr[start]
      start+=1
    ans=min(end-start+2,ans)

print(ans if ans<100001 else 0)