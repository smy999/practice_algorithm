# 풀이: 정렬, 반복문, 비교
def solution1(participant, completion):
    
    participant.sort()
    completion.sort()
    
    for i in range(len(completion)):
        if participant[i] != completion[i]:
            return participant[i]

    return participant[i+1]
    
 
#######################################


# 풀이: Counter 객체의 연산(-), dictionary
from collections import defaultdict

def solution2(participant, completion):
    answer = collections.Counter(participant) - collections.Counter(completion)
    return list(answer)[0]


#######################################


# 풀이: Hash 구조, dictionary
def solution3(participant, completion):
    temp = 0
    dict = {}
    
    for p in participant:
        dict[hash(p)] = p
        temp += hash(p)
    for c in completion:
        temp -= hash(c)
    
    return dict[temp]
