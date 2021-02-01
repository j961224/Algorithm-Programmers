import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer=0;
        int[][] fee = new int[n][n]; //그래프 형식으로 각 포인트 당 cost 계산
        
        for(int[] i : fares){
            fee[i[0]-1][i[1]-1]=i[2];
            fee[i[1]-1][i[0]-1]=i[2];
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j){
                    fee[i][j]=0;
                }
                else if(fee[i][j]==0){
                    fee[i][j]=10000000;
                }
            }
        }
        
        for(int i=0; i<n; i++){ // 이 순서가 매우 중요
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(fee[k][j]>fee[k][i]+fee[i][j]){
                        fee[k][j]=fee[k][i]+fee[i][j];
                    }
                }
            }
        }
        
        answer = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            answer=Math.min(answer, fee[s-1][i]+fee[i][a-1]+fee[i][b-1]);
        }
        return answer;
    }
}