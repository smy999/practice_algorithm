# 소수 규칙1: 2 ~ n의 제곱근으로 나누어 지는 수가 있으면 소수가 아니다.
from itertools import permutations
import math

def solution(numbers):
    answer =[]              # 가능한 소수의 개수
    perList = []            # 자리수별 가능한 모든 문자열 조합을 저장할 리스트
    
    for i in range(1, len(numbers)+1):
        # 문자열 조합 만들기
        perList = set(list(map("".join, permutations(list(numbers), i))))
        
        # 문자열 조합을 숫자로 변환하여 소수인지 검사한다.
        for _ in perList:
            perNum = int(_)                 # 문자열 숫자로 변환
            
            # 1이면 perList의 다음 원소로 넘어간다.
            if perNum < 2: continue
            
            checkNum = math.sqrt(perNum)    # 제곱근 구하기
            isdemi = True                   # 소수인지 판별하는 boolean 변수 (처음은 참이라 가정한다.)
            
            # 소수 검사
            for i in range(2, int(checkNum)+1):
                # 제곱근 이하의 수로 나누어 떨어지면 소수가 아니다.
                if perNum%i == 0:
                    isdemi = False
                    break
            
            # 위 소수 검사에서 한번도 나누어 떨어지지 않았으면 perNum은 소수다.
            if isdemi == True:
                answer.append(perNum)
    
    return len(set(answer))
