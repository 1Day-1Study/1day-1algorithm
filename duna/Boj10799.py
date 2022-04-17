import sys
intput=sys.stdin.readline
str=input().strip()

stick=0 #자르기전 막대 개수
result=0 # 막대 총합

for i in range(len(str)-1):
  if str[i]=='(' and str[i+1]==')': #레이저
    result+=stick
    #print("stick=",stick, "result=",result)
    
  elif str[i]==')' and str[i+1]==')': #막대 왼쪽 마지막 부분
    stick-=1
    #print("stick=",stick, "result=",result)
    
  elif str[i]=='(' and str[i+1]=='(': #막대 오른쪽 마지막 부분
    stick+=1
    result+=1
    #print("stick=",stick, "result=",result)

print(result)