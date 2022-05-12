import sys

input=sys.stdin.readline

n=int(input()) #개수
arr=[-1]*n

num=list(map(int,input().split()))
operate=list(map(int,input().split()))

#depth=0  #깊이
#temp=num[0] #처음값 넣기
max_r=-1000000000
min_r=1000000000

#전역변수는 참조는 할수 있지만, 함수내에서 값이 변경되어도 반영이 되지 않는다.

def dfs(depth,temp): 

  global max_r #함수 내 값 변경시 함수 밖에서도 적용
  global min_r
  
  if depth==n:
    if max_r<temp: #최대값
      max_r=temp
    if min_r>temp: #최소값
      min_r=temp
    return
    
  for i in range(len(operate)):
    if operate[i]>0:
      operate[i]-=1 #방문했음을 표시
      if i==0:  #+
        dfs(depth+1,temp+num[depth]) #더한값을 따로 저장해 보내주면 돌아왔을때 더한 값이 temp에 저장되있어 더한값으로 진행되 의도와 다르게 나온다.
      elif i==1:  #-
        dfs(depth+1,temp-num[depth])
      elif i==2:  #*
        dfs(depth+1,temp*num[depth])
      elif i==3:  #/
        if temp<0:
          dfs(depth+1,-(-temp//num[depth]))  #조건에 음수는 양수로 바꾸고 나눈다음 음수로 바꾸는게 존재한다.
        else:
          dfs(depth+1,temp//num[depth]) #조건에 나눗셈은 몫만 취한다가 존재한다.
      #print('d:',depth,'i:',i,'temp:',temp)
      
      operate[i]+=1  #방문하고 돌아왔음을 표시
      
dfs(1,num[0])  #처음 값은 넣어 놓을것다.
print(max_r)
print(min_r)  
