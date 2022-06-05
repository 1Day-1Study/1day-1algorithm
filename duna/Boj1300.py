n=int(input())
k=int(input())
'''
b=[i*j   #메모리 초과
   for i in range(1,n+1)
   for j in range(1,n+1)
  ]

b.sort()
'''

def is_valid(m):
  sum_num=0
  for i in range(1,n+1):
    sum_num+=min(m//i,n)  #n의 수보다 넘는 값이 존재해서 
  return sum_num>=k  #B(k)의 값이 같은 k의 값도 존재한다.

left=1
right=n*n 
#print(b)
while left<=right:
  mid=(left+right)//2

  if is_valid(mid):
    answer=mid
    right=mid-1  #최소값을 구해야한다.

  else:
    left=mid+1

print(answer)