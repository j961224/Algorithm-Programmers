import heapq

def solution(food_times, k):
    if sum(food_times) <=k:
        return -1
    
    q=[]
    for i in range(len(food_times)):
        heapq.heappush(q,(food_times[i],i+1)) # 우선순위 큐
        
    sumvalue=0 # 시간 누적
    previous=0 # 직전 다 먹은 음식 시간
    len1=len(food_times)
    while sumvalue+((q[0][0]-previous)*len1)<=k:
        nowvalue = heapq.heappop(q)[0]
        sumvalue+=(nowvalue-previous)*len1 # 먹기 위해 사용한 시간 누적
        len1-=1
        previous=nowvalue # 몇 번 돌았는지 체크를 위해서
    
    
    answer = sorted(q,key =lambda x: x[1])
    return answer[(k-sumvalue)%len1][1]