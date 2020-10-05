# 풀이 반복문, 단순비교

def solution1(phone_book):
    phone_book.sort()
    
    for i in range(len(phone_book)):
        for j in range(i+1, len(phone_book)):
            if phone_book[i] == phone_book[j][:len(phone_book[i])]:
                return False
    
    return True
    
##################################################################

# 풀이 zip(), startswith() 함수 사용

def solution2(phone_book):
    phone_book.sort()
    
    for p1, p2 in zip(phone_book, phone_book[1:]):
        if p2.startswith(p1):
            return False
    
    return True


##################################################################

# 풀이 정규식

import re

def solution3(phone_book):
    for pb1 in phone_book:
        r = re.compile("^" + pb1)
        print(r)
        
        for pb2 in phone_book:
            if pb1 != pb2 and r.match(pb2):
                return False
    return True


##################################################################

# 풀이 Hash

def solution(phone_book):
    dic = {}
    
    for pb in phone_book:
        dic[pb] = 1
        
    for pb in phone_book:
        temp = ""
        for i in pb:
            temp += i
            if temp != pb and temp in dic:
                return False
    return True
