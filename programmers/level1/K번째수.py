def solution(array, commands):
    answer = []
    
    for i in range(len(commands)):
        cut = []
        cut = array[commands[i][0]-1:commands[i][1]]
        cut.sort()
        answer += [cut[commands[i][2]-1]]
    return answer
