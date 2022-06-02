n=int(input())
arr=input()

def add(c): #해당 단어 추가 하기
  global kind
  t=ord(c)-ord('a') #배열 0부터 배치하기 위해
  cnt[t]+=1
  if cnt[t]==1: #해당 알파벳을 처음 추가 한다면
    kind+=1 #종류 개수 +1

def delete(c):  #해당 단어 없애기
  global kind
  t=ord(c)-ord('a')
  cnt[t]-=1
  if cnt[t]==0: #해당 알파벳의 개수가 0 이 된다면, 더 이상 존재하지 않는다면
    kind-=1 #종류의 개수 -1

left=0  
kind=0  #종류 개수
cnt=[0]*26  #알파벳 종류 별 리스트
max_len=0  # 문자 최대 길이

for right in range(len(arr)):
  add(arr[right])
  while kind>n: #종류가 n 보다 클때 반복
    delete(arr[left])
    left+=1

  max_len=max(max_len,(right-left)+1)   #길이가 가장 큰 수
  

print(max_len)
