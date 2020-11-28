def solution(brown, yellow):
    m = 3       # 가로 길이:m, 가로의 최소값은 3이다. (세로 길이:n)
    
    # 반복문을 통해 완전탐색 구현
    while True:
        for n in range(1, m+1):
            if (brown+yellow == m*n) and (brown == (m+n)*2-4): 
                return [m, n]
        m += 1
