# 풀이1

import math

def solution1(progresses, speeds):
    answer = []
    dev = [math.ceil((100-p)/s) for p, s in zip(progresses, speeds)]
    print(dev)
    
    while dev:
        d = dev.pop(0)
        r = 1
        
        while len(dev) > 0:
            if d >= dev[0]:
                dev.pop(0)
                r += 1
            else:
                break
        
        answer.append(r)
    return answer



#################################################################
# 풀이2

def solution2(progresses, speeds):
    answer = []
    time = 0
    count = 0
    
    while len(progresses) > 0:
        if (progresses[0] + time * speeds[0]) >= 100:
            progresses.pop(0)
            speeds.pop(0)
            count += 1
        else:
            if count > 0:
                answer.append(count)
                count = 0
            time += 1
    answer.append(count)
    
    return answer
