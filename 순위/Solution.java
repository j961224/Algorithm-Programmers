package prograph순위;
import java.util.*;

//첫 번째 문제처럼 queue로 처음에 접근 시도
//이것은 참조함 => 덧셈으로 INF인 경우는 경로 없는 것으로 만들기에 대한 아이디어
public class Solution {
	public int solution(int n, int[][] results) {
        int answer = 0;
        int INF=2000000;
        int distance[][]=new int[n+1][n+1];
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                distance[i][j]=INF;
            }
        }//전체 경로 다 무한대로
        
        for(int i=0; i<results.length; i++){
            distance[results[i][0]][results[i][1]]=1;
        }//현재로 존재하는 경로 1로
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                for(int k=1; k<n+1; k++){
                    if(distance[j][k]>distance[j][i]+distance[i][k]){
                        distance[j][k]=distance[j][i]+distance[i][k];
                    }
                }
            }
        }//지나갈 수 있는 경로 INF에서 다른 정수로 고치기
        
        for(int i=1; i<n+1; i++){
            boolean check = true;
            for(int j=1; j<n+1; j++){
                if(i==j) continue;
                if(distance[i][j] == INF && distance[j][i] == INF){
                    check=false;
                    break;
                }//하나라도 j랑 연결 안 된 것이 있으면 순위 측정 못 하므로 break
            }
            if(check) 
                answer++;
        }
        return answer;
    }
}
