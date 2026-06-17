def solution(n):
    answer = 0
    k = n // 2
    for i in range(k+1):
        answer += 2*i
    return answer