package prograph����ճ��;
import java.util.*;

public class Solution {
	public int solution(int n, int[][] edge) {
        int answer = 0;
        int max =0;
        int distance[] = new int[n+1]; // 1���� �Ÿ� ����
        boolean check[][] = new boolean[n+1][n+1]; 
        for(int i = 0; i < edge.length; i++) {
            check[edge[i][0]][edge[i][1]] = check[edge[i][1]][edge[i][0]] = true;
        }//������̹Ƿ� ���� ����Ǿ� ������ ����
        
        Queue<Integer> qu = new LinkedList<Integer>();
        qu.add(1);//���⼭�� 1���� �����Ͽ� �Ÿ� �����ϴ� ������ �ϰڴ�.
        while(!qu.isEmpty()){
            int k = qu.poll();
            for(int j=2; j<n+1; j++){
                if(distance[j]==0 && check[k][j]==true){
                    distance[j]=distance[k]+1;
                    qu.add(j);
                }
            }
        }
        //distance ���� ū ���� max�� �����ϱ�
        for(int i=0; i<n+1; i++){
            if(max<distance[i]){
                max=distance[i];
            }
        }
        
        for(int i=0; i<n+1; i++){
            if(max == distance[i]){
                answer++;
            }
        }
        
        return answer;
    }
}
