#1번째 시도
#djisktra와 check로 변형되는지 XOR을 이용하여 check하여 distance 갱신
#=> 테스트케이스 3,5,6,7 통과 X
# #변형된 djisktra 사용해보자!
# import sys
# import heapq

# def solution(n, start, end, roads, traps):
#     INF = int(1e9)
#     answer = 0
#     distance = [INF]*(n+1)
#     check = [False]*(n+1)
#     #그대로 path
#     graphFalse = [[] for i in range(n+1)]
#     #바뀐 path
#     graphTrue = [[] for i in range(n+1)]
#     for i in roads:
#         graphFalse[i[0]].append((i[1],i[2]))
#         graphTrue[i[1]].append((i[0],i[2]))
#     q=[]
#     distance[start]=0
#     heapq.heappush(q,(0,start))
    
#     while q:
#         dist,now = heapq.heappop(q)
        
#         if distance[now]<dist:
#             continue
        
#         if now in traps:
#             if check[now]==True:
#                 check[now]=False
#             else:
#                 check[now]=True
        
#         for i in graphFalse[now]:
#             if check[now]==True and check[i[0]]==True:
#                 cost = dist+i[1]
#                 if cost<distance[i[0]]:
#                     distance[i[0]]=cost
#                     heapq.heappush(q,(cost,i[0]))
#             elif check[now]==False and check[i[0]]==False:
#                 cost = dist+i[1]
#                 if cost<distance[i[0]]:
#                     distance[i[0]]=cost
#                     heapq.heappush(q,(cost,i[0]))
                    
#         for i in graphTrue[now]:
#             if check[now]==False and check[i[0]]==True:
#                 cost = dist+i[1]
#                 if cost<distance[i[0]]:
#                     distance[i[0]]=cost
#                     heapq.heappush(q,(cost,i[0]))
#             elif check[now]==True and check[i[0]]==False:
#                 cost = dist+i[1]
#                 if cost<distance[i[0]]:
#                     distance[i[0]]=cost
#                     heapq.heappush(q,(cost,i[0]))
    
    
#     return distance[end]

import sys
import heapq
#비트마스킹+djisktra
def solution(n, start, end, roads, traps):
    INF = int(1e9)
    answer = 0
    distance = [[INF for _ in range(n+1)] for _ in range(1<<len(traps))]
    trap_index = {value:index for index,value in enumerate(traps)}
    
    graph = [[] for i in range(n+1)]
    for i in roads:
        graph[i[0]].append((i[1],i[2],0))
        graph[i[1]].append((i[0],i[2],1))
    q=[]
    distance[0][start]=0
    heapq.heappush(q,(0,start,0))
    
    while q:
        dist,now,state = heapq.heappop(q)
        
        if end==now:
            answer = dist
            break
        if distance[state][now]<dist:
            continue
        
        for i in graph[now]:
            next_state=state
            if now in traps:
                # 도착지점, 시작지점 둘다 trap인 경우
                if i[0] in traps:
                    cur_flag = ((1&(state>>trap_index[now])) + (1&(state>>trap_index[i[0]])))%2
                    next_state = state^(1<<trap_index[i[0]]) # XOR
                #도착지점만 trap에 속하지 않을 경우
                else:
                    cur_flag = (1&(state>>trap_index[now]))
            else:
                #시작점 trap이 아니고 도착지점이 trap인 경우
                if i[0] in traps:
                    cur_flag = (1&(state>>trap_index[i[0]]))
                    next_state=state^(1<<trap_index[i[0]])
                #둘다 아니라면
                else:
                    cur_flag=0
            
            if cur_flag==i[2]:
                if distance[next_state][i[0]]>dist+i[1]:
                    distance[next_state][i[0]]=dist+i[1]
                    heapq.heappush(q,(distance[next_state][i[0]],i[0],next_state))
                    
    
    
    return answer