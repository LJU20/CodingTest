def solution(my_string):
    for st in 'aieou':
        my_string = my_string.replace(st,'')

    return my_string