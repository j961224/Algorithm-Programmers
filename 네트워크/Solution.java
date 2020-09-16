package proDFSBFS��Ʈ��ũ;
import java.util.*;
//ó���� ��Ŀ��� ������ �κ� 1�� ������ n�� �ٰ� �� ���� answer�� �ϸ� answer�� 0�̳� ������ �Ǹ� 1�� ����� => ���ܰ� ����

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
                dfs(j,computers);//dfs�� 1�� �ִ� node�� ã���� �ű⼭ �� ����� node�� ã�� �̾ ã��
            }
        }
    }
}
