import sys

result=1
n=int(sys.stdin.readline())
if n>1:
  for i in range(2,n+1): #2! => 1*2
    result*=i 
  print(result)
else:
  print(1)