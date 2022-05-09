import sys

input=sys.stdin.readline
m,n=map(int,input().split())
prime=[False,False]+[True]*(n-1) #0~1제외
#print(prime)

for i in range(2,(n//2)+1): #절반까지 봐도 이미 뒤에 수는 다 계산되있다. 16//2=8, 2*8이 16이라서 범위내 수까지 구할 수 있다., 만약 i가 9라고 생각 해보면 9는 그 다음 배수가 9*2=18이다. 그러니 절반까지 해도 된다.
  if prime[i]: #이미 배수라고 판정이 나면 이 수의 배수도 이미 배수라고 판정되있으니 안한다.
    for j in range(i*2,n+1,i): #여기서 i의 배수를 구함
        prime[j]=False
        #print(i,j)
        
for i in range(m,n+1):
  if prime[i]==True:
    print(i)
    