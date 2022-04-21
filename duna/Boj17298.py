import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
stack = []
answer = [-1 for i in range(n)]

for i in range(len(arr)):
    while stack and arr[stack[-1]] < arr[i]: #0, 1 /오큰수
        answer[stack.pop()] = arr[i] #stack의 마지막 수, 값을 바꿈
    stack.append(i)
print(" ".join(map(str,answer)))