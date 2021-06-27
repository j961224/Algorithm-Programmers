import sys
import heapq
from collections import defaultdict
sys.setrecursionlimit(1000000)

answer=0
def dfs(x,a,visit,tree):
    global answer
    visit[x]=1
    
    for i in tree[x]:
        if not visit[i]:
            a[x]+=dfs(i,a,visit,tree)
    answer+=abs(a[x])
    #결국 x=0은 0이 answer에 더해짐
    
    #x는 4,2일때, 2씩 더해지고 3일때, 5더해져 9가 나옴 -> 0일때는 0이 되어있음
    return a[x]

    
def solution(a, edges):
    global answer
    
    if(sum(a)!=0):
        return -1
    
    tree = defaultdict(list)
    for i,j in edges:
        tree[i].append(j)
        tree[j].append(i)
    
    visit = [0]*len(a)
    dfs(0,a,visit,tree)
    return answer