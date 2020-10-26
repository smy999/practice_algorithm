# 풀이1 이중 for문

def solution1(prices):
    answer = [0]*len(prices)
    for i in range(len(prices)-1):
        for j in range(i, len(prices)-1):
            if prices[i] <= prices[j]:
                answer[i]+=1
            else:
                break
    return answer



#########################################
# 풀이2 Stack 자료구조

from collections import deque

def solution2(prices):
    answer = []
    q = deque(prices)
    while q:
        p = q.popleft()
        sec = 0  
        for _ in q:
            sec += 1
            if p > _:
                break
        answer.append(sec) 
    return answer
