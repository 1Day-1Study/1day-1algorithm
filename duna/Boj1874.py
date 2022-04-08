import sys
input=sys.stdin.readline

n=int(input())
stack=[]
top=1 #어떤 숫자까지 넣었는지
answer=[] #답 저장하는곳 
for _ in range(n):
  num=int(input())
  if top<num:
    for i in range(top,num): # stack에 다음 들어갈 수(top)에서 num-1까지 스택에 넣고 +,- 표기
      stack.append(i)
      answer.append('+')
    answer.append('+')
    answer.append('-')
    top=num+1 #num의 다음 stack에 넣을수 저장 
    
  elif len(stack)>0 and stack[-1]==num: # stack에 이미 들어 있을때, stack 제일 위에 수 다름
    stack.pop()
    answer.append('-')

  elif top==num: #stack에 안 들어 있지만 굳이 스택에 넣을 필요 없을때
    answer.append('+')
    answer.append('-')
    top+=1
  
  else:
    print("NO")
    break
      
  #print("num=",num,"stack=", stack,"\nanswer=",answer)
  
if top==n+1 and len(stack)==0: #모든 작업을 정상적으로 완료했을 때
  print("\n".join(answer))