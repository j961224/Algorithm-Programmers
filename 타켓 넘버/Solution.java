package proDFSBFS타켓넘버;
import java.util.*;
//더하기 빼기만 있으니 각 배열 요소에 +,- 경우를 체크하여 합이 target과 같으면 answer+1을 한다.

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
            numbers[node]*=1; //해당 node를 양수 취하기
            dfs(numbers,node+1,target);
            
            numbers[node]*=-1;//해당 node 음수 취하기
            dfs(numbers,node+1,target);
            //dfs 형식의 재귀함수 2번
        }
    }
}
