def solution(array):
    tempArray = array[:]
    array.sort()
    answer = array[-1]
    num = 0
    answerArray = []
    answerArray.append(answer)
    for i in tempArray:
        if i != answer:
            num += 1
        else:
            answerArray.append(num)
    return answerArray
