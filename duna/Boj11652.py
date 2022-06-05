import sys
input=sys.stdin.readline
n=int(input())
card={}
for _ in range(n):
  c=int(input())
  card[c]=card.get(c,0)+1 #get으로 카드 번호가 저장되있으면, 해당 값 반환, 아니면 0 반환, +1 카드 갯수 세어줌
#print(card)
arr=sorted(card.items(), key=lambda x:(-x[1], x[0])) #카드개수 내림차순, 카드 번호 오름차순 
print(arr[0][0]) #맨 처음 카드 번호