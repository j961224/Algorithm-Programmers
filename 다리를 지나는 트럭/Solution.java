package prostack�ٸ���������Ʈ��;
import java.util.*;
//�� �ٸ��� ���� �� ���Ұ� ���� ������ �����̴� Queue�� ����

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
                    sum -=q.poll(); //�տ� �ִ� ���Ұ� ������ ���̴� queue�� ����
                }
                else{
                    if(sum+t>weight){ //���ÿ� 1~2�� �϶�
                        q.offer(0);
                        answer++;
                    }
                    else{//���ÿ� ����ð� 3�ʰ� �� �� ����
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
