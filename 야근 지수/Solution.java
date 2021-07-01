import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        // int형 priorityQueue 선언 (우선순위가 높은 숫자 순)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        long answer = 0;
        long sum = 0;
        
        for(int i=0; i<works.length; i++){
            pq.offer(works[i]);
        }
        
    
        for(int i=0; i<n; i++){
            int tmp = pq.poll();
            if(tmp<=0) break; //최고가 0이면 더 계산할 필요가 없이 0이므로
            pq.offer(tmp-1);
        }
        
        while(!pq.isEmpty()){
            int k = pq.poll();
            answer+=k*k;
        }
        
        return answer;
    }
}