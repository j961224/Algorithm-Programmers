package proDFSBFSŸ�ϳѹ�;
import java.util.*;
//���ϱ� ���⸸ ������ �� �迭 ��ҿ� +,- ��츦 üũ�Ͽ� ���� target�� ������ answer+1�� �Ѵ�.

public class Solution {
	static int answer=0;
    public int solution(int[] numbers, int target) {
        
        dfs(numbers,0,target);
        return answer;
    }
    
    public void dfs(int[] numbers, int node, int target){
        int sum=0;
        if(node==numbers.length){
            for(int i=0; i<numbers.length; i++){
                sum+=numbers[i];
            }
            if(sum==target){
                answer++;
            }
        }
        else{
            numbers[node]*=1; //�ش� node�� ��� ���ϱ�
            dfs(numbers,node+1,target);
            
            numbers[node]*=-1;//�ش� node ���� ���ϱ�
            dfs(numbers,node+1,target);
            //dfs ������ ����Լ� 2��
        }
    }
}
