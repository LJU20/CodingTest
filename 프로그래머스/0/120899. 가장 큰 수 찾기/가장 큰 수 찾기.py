def solution(array):
    max_num = max(array)
    index = array.index(max_num)
    return [max_num, index]
