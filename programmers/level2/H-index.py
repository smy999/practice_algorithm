def solution(citations):
    citations.sort()
    cLen = len(citations)
    for i in range(cLen):
        if cLen - citations[i] <= i:
            return cLen-i
    return 0
