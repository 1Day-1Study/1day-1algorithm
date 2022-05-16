import sys
input=sys.stdin.readline
n=int(input())
word=[]
for _ in range(n):
  word.append(input().strip())

word=list(set(word)) #중복제거
word.sort() #사전순
word.sort(key=len) #길이순

for w in word:
  print(w)