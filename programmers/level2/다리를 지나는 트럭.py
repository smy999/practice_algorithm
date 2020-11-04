def solution(bridge_length, weight, truck_weights):
    answer = 0                      # 0. 경과시간
    truck_que = [0]*bridge_length   # 0. 다리를 건너는 중인 트럭의 무게를 나타내는 큐
    
    while truck_que:
        # 1. 1초에 하나의 트럭 이상이 들어올 수 없다.
        answer += 1
        # 2. 다리를 끝까지 건넌 트럭을 제거한다.
        truck_que.pop(0)     
        
        # 3. 대기 중인 트럭이 있을 때에만 실행
        if truck_weights:
            # 3-1. 대기 중인 첫 번째 트럭이 다리를 건너도 제한무게(weight)를 넘지 않을 때
            if sum(truck_que)+truck_weights[0] <= weight:
                # truck_que에 추가
                truck_que.append(truck_weights.pop(0))
            # 3-2. 제한무게를 넘는다면 새롭게 다리를 건너는 트럭이 없을 때
            else:
                # 새롭게 다리를 건더는 트럭이 없다.(0 추가 = 무게가 0)
                truck_que.append(0)
    return answer
