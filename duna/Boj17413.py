import sys

input=sys.stdin.readline

str=list((input().strip()))

temp=[] #문자를 넣을 임시 저장 장소
reverse=True #역순으로 출력 할지

for i in range(len(str)):

  if str[i] == "<": #'<'하면 int와 nonetype은 비교 타입이 아니라고 나온다.
    if temp: #태그 전에 저장한 문자가 있는지
      print(''.join(temp[::-1]),end='')
      temp=[]
    reverse=False #태그부분은 뒤집어서 출력 안함
  
  if reverse: #역순
    if str[i] ==' ': #공백기준 나눠 출력
      print(''.join(temp[::-1]),'',end='') #뒤집어 출력
      temp=[]
      
    else:
      temp.append(str[i]) #태그 제외 문자 저장
    
      
  else: #태그
    print(str[i],end='') 
    if str[i] == ">":
      reverse=True 

if temp: # 끝난 후 남은 문자가 있는지
  print(''.join(temp[::-1]),end='') 
  
