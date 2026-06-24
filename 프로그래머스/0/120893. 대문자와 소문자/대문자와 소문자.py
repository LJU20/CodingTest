def solution(my_string):
    answer = ''
    for st in my_string:
        if st.isupper():
            answer += st.lower()
        else: answer += st.upper()
    return answer