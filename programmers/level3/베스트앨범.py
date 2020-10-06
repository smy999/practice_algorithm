def solution(genres, plays):
    answer = []
    album_dic = {} 
    album_list = []
    
    # album_dic {장르 : (재생 횟수, 고유 번호)} Dictionary 생성
    for i in range(len(genres)):
        if genres[i] not in album_dic:
            album_dic[genres[i]] = [(plays[i], i)]
        else:
            album_dic[genres[i]].append((plays[i], i)) 
    print(album_dic)
    
    # 장르별 노래를 재생 횟수에 따라 내림차순 정렬
    for item in album_dic.items():
        album_dic[item[0]] = sorted(item[1], key = lambda x:(-x[0], x[1]))
    print(album_dic)
    
    # album_list [(장르, 총 재생 횟수)] List 생성
    for item in album_dic.items():
        sum = 0
        for i in range(len(item[1])):
            sum += item[1][i][0]
        album_list.append((item[0], sum))
    print(album_list)
    
    # album_list 
    album_list.sort(key = lambda x:x[1], reverse = True)
    print(album_list)
    
    # 베스트 앨범에 들어갈 노래 추가
    for i in range(len(album_list)):
        # 장르에 속한 곡이 한 곡일 때, 하나의 곡만 선택한다
        if len(album_dic[album_list[i][0]]) == 1:
            answer.append(album_dic[album_list[i][0]][0][1])
        # 장르에 속한 곡이 두 곡 이상일 때, 가장 재생이 많이된 순으로 선택한다.
        else:
            answer.append(album_dic[album_list[i][0]][0][1])
            answer.append(album_dic[album_list[i][0]][1][1])

    return answer
