import heapq;
import sys
INF = int(1e9)

#dijsktra 사용할 예정
def solution(N, road, K):
    answer = 0
    distance = [INF]*(N+1)
    graph = [[] for i in range(N+1)]
    
    for i in range(len(road)):
        graph[road[i][0]].append((road[i][1],road[i][2]))
        graph[road[i][1]].append((road[i][0],road[i][2]))
    
    dijsktra(1,distance,graph)
    
    for i in range(1,N+1):
        if distance[i]!=INF:
            if distance[i]<=K:
                answer+=1
    return answer

def dijsktra(start,distance,graph):
    q=[]
    
    heapq.heappush(q,(start,0))
    distance[start]=0
    while q:
        now, dist = heapq.heappop(q)
        
        if distance[now]<dist:
            continue
        for i in graph[now]:
            cost = dist+i[1]
            if(cost<distance[i[0]]):
                distance[i[0]]=cost
                heapq.heappush(q,(i[0],cost))