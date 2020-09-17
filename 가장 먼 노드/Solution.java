package prograph가장먼노드;
import java.util.*;

public class Solution {
	public int solution(int n, int[][] edge) {
        int answer = 0;
        int max =0;
        int distance[] = new int[n+1]; // 1과의 거리 저장
        boolean check[][] = new boolean[n+1][n+1]; 
        for(int i = 0; i < edge.length; i++) {
            check[edge[i][0]][edge[i][1]] = check[edge[i][1]][edge[i][0]] = true;
        }//양방향이므로 서로 연결되어 유무를 저장
        
        Queue<Integer> qu = new LinkedList<Integer>();
        qu.add(1);//여기서는 1에서 시작하여 거리 측정하는 것으로 하겠다.
        while(!qu.isEmpty()){
            int k = qu.poll();
            for(int j=2; j<n+1; j++){
                if(distance[j]==0 && check[k][j]==true){
                    distance[j]=distance[k]+1;
                    qu.add(j);
                }
            }
        }
        //distance 가장 큰 것을 max에 저장하기
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
