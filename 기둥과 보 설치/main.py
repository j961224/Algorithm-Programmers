def check(answer):
    for x,y,sorting in answer:
        if sorting==0: #'기둥일 경우'
            if y==0 or [x,y-1,0] in answer or [x,y,1] in answer or [x-1,y,1] in answer:
                continue
            return False
        if sorting==1: #'보일 경우'
            if [x,y-1,0] in answer or [x+1,y-1,0] in answer or ([x-1,y,1] in answer and [x+1,y,1] in answer):
                continue
            return False
    return True

def solution(n, build_frame):
    answer = []
    for frame in build_frame:
        x,y,sorting,possible = frame
        if possible == 0:
            answer.remove([x,y,sorting])
            if not check(answer):
                answer.append([x,y,sorting])
        if possible == 1:
            answer.append([x,y,sorting])
            if not check(answer):
                answer.remove([x,y,sorting])
    return sorted(answer)