import sys
from collections import Counter
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
stack = []
answer = [-1 for i in range(n)]

cnt=Counter(arr) #각 원소 개수 #디렉토리 형식


for i in range(len(arr)):
    while stack and cnt[arr[stack[-1]]] < cnt[arr[i]]: #0, 1 /오큰수
        answer[stack.pop()] = arr[i] #stack의 마지막 수, 값을 바꿈
    stack.append(i)
print(" ".join(map(str,answer)))