import sys
input=sys.stdin.readline
n=int(input())

def gcd(a,b): #유클리드 호제법
  while b:
    a,b=b,a%b
  return a

for _ in range(n):
  a,b=map(int,input().split()) 
  if a<b: #(a>b의 조건 때문에 값 스위칭)
    a,b=b,a

  #print('a=',a,'b=',b)
  print(int((a*b)/gcd(a,b)))