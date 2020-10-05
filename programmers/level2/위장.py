# 풀이 Hash

def solution1(clothes):
    dic = {}
    cnt = 1
    
    for c in clothes:
        if c[1] in dic:
            dic[c[1]] += 1
        else:
            dic[c[1]] = 1
    
    for v in dic.values():
        cnt *= (v+1)
    
    return cnt-1


##############################################

# 풀이 lambda, recude(), Conter()

from collections import Counter
from functools import reduce

def solution2(clothes):
    return reduce(lambda x, y : x*(y+1), Counter([_[1] for _ in clothes]).values(), 1) -1
