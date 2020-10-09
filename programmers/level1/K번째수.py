# 풀이1

def solution1(array, commands):
    answer = []
    
    for i in range(len(commands)):
        cut = []
        cut = array[commands[i][0]-1:commands[i][1]]
        cut.sort()
        answer += [cut[commands[i][2]-1]]
    return answer

########################################################

# 풀이2

def solution2(array, commands):
    return list(map(lambda x:sorted(array[x[0]-1:x[1]])[x[2]-1], commands))
