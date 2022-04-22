import sys
input=sys.stdin.readline

x,y=map(int,input().split())

#유클리드 호제법
#x%y=r
#x와 y의 최대공약수 == y와 r의 최대 공약수

#최대 공약수
def GCD(x,y):
  while y:
    x,y=y,x%y
  return x

#최소 공배수
def LCM(x,y):
  result=(x*y)//GCD(x,y)
  return result

print(GCD(x,y))
print(LCM(x,y))

#import math
#math.gcd(x,y) (Greatest Common Divisor)
#math.lcm(x,y) (Least Common Multiple)