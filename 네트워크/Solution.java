package proDFSBFS네트워크;
import java.util.*;
//처음에 행렬에서 오른쪽 부분 1의 갯수를 n에 다가 뺀 것을 answer로 하면 answer가 0이나 음수가 되면 1로 출력함 => 예외가 있음

public class Solution {
	static int[] check;
    public int solution(int n, int[][] computers){
        
        int answer=0;
        check = new int[n];
        
        for(int i=0; i<n; i++){
            check[i]=0;
        }
        
        for(int i=0; i<n; i++){
            if(check[i]==0){
                answer++;
                dfs(i,computers);
            }
        }
        return answer;
    }
    
    static void dfs(int i, int[][] computers){
        check[i]=1;
        for(int j=0; j<computers.length; j++){
            if(check[j]==0 && computers[i][j]==1){
                dfs(j,computers);//dfs로 1이 있는 node를 찾으면 거기서 또 연결된 node를 찾아 이어서 찾기
            }
        }
    }
}
