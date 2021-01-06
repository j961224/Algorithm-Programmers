import java.util.*;
//LRU 알고리즘 : 가장 오랫동안 참조하지 않는 페이지를 캐시에서 교체 -> Queue 사용
//LFU 알고리즘 : 가장 적게 참조한 페이지를 캐시에서 교체

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> qu = new LinkedList<>();
        if(cacheSize==0){ // cacheSize가 0이면 항상 cache miss므로
            return 5*cities.length;
        }
        for(int i=0; i<cities.length; i++){
            String tmp = cities[i].toUpperCase();
            
            if(qu.remove(tmp)){//remove method로 Queue에 요소가 있다면 if문 들어가고 삭제
                qu.offer(tmp);
                answer+=1;
            }
            else{
                int size = qu.size();
                if(size==cacheSize){
                    qu.poll();
                    qu.offer(tmp);
                    answer+=5;
                }
                else{
                    qu.offer(tmp);
                    answer+=5;
                }
            }
        }
        
        return answer;
    }
}