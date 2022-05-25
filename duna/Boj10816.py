from collections import Counter
n=int(input())
card=list(map(int,input().split()))
m=int(input())
num=list(map(int,input().split()))

###########경계값 찾기############

def card_search(target):
  left,right=0,n-1
  while left<=right:
    mid=(left+right)//2
    
    if card[mid]==target:
      return mid
      #return True

    elif card[mid]>target:
      right=mid-1

    else:
      left=mid+1

  return -1
  #return False

def left_search(p,target):  #파이썬은 시간 초과 난다.
  left,right=0,p-1
  position=p
  while left<=right:
    mid=(left+right)//2
    
    if card[mid]==target:
      position=mid
      right=mid-1

    elif card[mid]>target:
      right=mid-1

    else:
      left=mid

  return position

def right_search(p,target):
  left,right=p+1,n-1
  position=p
  while left<=right:
    mid=(left+right)//2
    
    if card[mid]==target:
      position=mid
      left=mid+1

    elif card[mid]>target:
      right=mid-1

    else:
      left=mid

  return position

card.sort()

for t in num: 
  p_num=card_search(t)
  if p_num==-1:
    print(0,end=' ')
  else:
    p_left=left_search(p_num,t)
    p_right=right_search(p_num,t)
    total=p_right-p_left+1
    
    print(total,end=' ')

###########위치값 찾아 counter 검색############

def card_search(target):
  left,right=0,n-1
  while left<=right:
    mid=(left+right)//2
    
    if card[mid]==target:
      #return mid
      return True

    elif card[mid]>target:
      right=mid-1

    else:
      left=mid+1

  #return -1
  return False

#print(counter)
card.sort()
counter=Counter(card)
for t in num:

  if card_search(t):  #위치값을 찾고 count로 검색
    print(counter[t],end=' ')
  else:
    print(0,end=' ')

###########counter값으로 바로 검색############

counter=Counter(card)
for t in num:  #count값으로 바로 검색 시간이 3배정도 더 빠르다.
  print(counter.get(t,0),end=' ')