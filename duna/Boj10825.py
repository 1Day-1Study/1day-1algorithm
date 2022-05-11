import sys
input=sys.stdin.readline

info=[]
n=int(input())

for i in range(n):
  name,ko,en,math=input().split()
  info.append({'ko':int(ko), 'en':int(en), 'math':int(math), 'name':name}) #ko:국어, en:영어, math:수학, name:이름 
#print(info)

sortInfo=sorted(info, key=lambda x:(-x['ko'], x['en'],-x['math'],x['name'])) #ko:내림차순, en:오름차순, math:내림차순, name:오름차순

for i in range(n):
  print(sortInfo[i]['name'])

#딕셔너리 다중 조건으로 정렬하기