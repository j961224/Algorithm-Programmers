package prostack다리를지나는트럭;
import java.util.*;
//각 다리에 먼저 온 원소가 먼저 빠지는 형식이니 Queue를 선택

public class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        
        int sum=0;
        for(int t : truck_weights){
            while(true){
                if(q.isEmpty()){
                    q.offer(t);
                    sum += t;
                    answer++;
                    break;
                }
                else if(q.size()==bridge_length){
                    sum -=q.poll(); //앞에 있던 원소가 빠지는 것이니 queue를 선택
                }
                else{
                    if(sum+t>weight){ //예시에 1~2초 일때
                        q.offer(0);
                        answer++;
                    }
                    else{//예시에 경과시간 3초가 될 때 적용
                        q.offer(t);
                        sum +=t;
                        answer++;
                        break;
                    }
                }
                
                
            }
            
        }
        
        
        return answer+bridge_length;
    }
}
