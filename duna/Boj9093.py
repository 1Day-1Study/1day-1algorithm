import sys

input=sys.stdin.readline

def wordReverse(str):
  w=''
  for i in range(len(str)-1,-1,-1):
    w+=str[i]
  return w

T=int(input())
#print("T=",T)
for _ in range(T):
  str=input().split()
  arr=list(map(wordReverse,str))
  #result =" ".join(arr)
  print(" ".join(arr))