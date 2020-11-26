def solution(priorities, location):
    cnt = 0             # 출력 개수
    loc = location      # 인쇄 요청 문서 위치
    
    # 요청 문서 출력 때까지 반복
    while 1:
        p = priorities.pop(0)       # 대기목록의 첫 번째 문서
        
        # p보다 중요도가 큰 문서가 있는지 확인
        for _ in priorities:
            flag = 0                # 1: 첫 번째 문서보다 중요도 클 때  0: 같거나 작을 때
            
            # p보다 중요도가 큰 문서가 있을 때
            if _ > p:
                priorities.append(p)            # 대기목록 마지막에 추가
                if loc > 0: loc -= 1            # 요청 문서 위치 1만큼 앞으로 변경
                else: loc = len(priorities)-1   # [caution] -1 안해서 실패
                
                flag = 1                        # 첫 문서보다 중요도가 큰 문서가 있음을 나타냄 
                print('flag: ',flag)
                break

        # p보다 중요도가 큰 문서가 없을 때
        if flag == 0:
            cnt += 1                # 인쇄한다. (+ 출력개수 증가)
            print('cnt: ',cnt)
            if loc == 0:            # 인쇄한 문서가 요청 문서이면 몇 번째로 출력되었는지 반환
                return cnt
            else:
                loc -= 1            # 인쇄 문서가 요청 문서가 아니면 위치 1만큼 앞으로 변경
                print('loc: ', loc)
