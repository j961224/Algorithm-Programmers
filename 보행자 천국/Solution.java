//답은 맞지만 시간이 초과남
// import java.util.*;
// class Dot{
//     int x;
//     int y;
//     int sorting;
//     int direction;
//     public Dot(int x, int y, int sorting, int direction){
//         this.x=x;
//         this.y=y;
//         this.sorting=sorting;
//         this.direction=direction;
//     }
// }
// class Solution {
//     static int MOD = 20170805;
//     static int[] xx = {0,1}; //직진,우회전,좌회전 -> 가는 방향
//     static int[] yy = {1,0};
//     public int solution(int m, int n, int[][] cityMap) {
//         int answer = 0;
        
//         Queue<Dot> qu = new LinkedList<>();
//         qu.add(new Dot(0,0,cityMap[0][0],0));
        
//         while(!qu.isEmpty()){
//             Dot tmp = qu.poll();
//             if(tmp.x== m-1 && tmp.y == n-1){
//                 answer++;
//             }
//             for(int i=0; i<2; i++){
//                 int tmpx=tmp.x+xx[i];
//                 int tmpy=tmp.y+yy[i];
//                 if(0<=tmpx && tmpx<m && 0<=tmpy && tmpy<n && cityMap[tmpx][tmpy]!=1){
//                     if(tmp.sorting==0){
//                         qu.add(new Dot(tmpx,tmpy,cityMap[tmpx][tmpy],i));
//                     }
//                     if(tmp.sorting==2){
//                         if(tmp.direction==i){
//                             qu.add(new Dot(tmpx,tmpy,cityMap[tmpx][tmpy],i));
//                         }   
//                     }
//                 }
//             }
//         }
//         answer=answer%MOD;
//         return answer;
//     }
// }

//DP 시도
import java.util.*;

class Solution {
    static int MOD = 20170805;
    static int[] xx = {0,1}; //직진,우회전,좌회전 -> 가는 방향
    static int[] yy = {1,0};
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m + 1][n + 1][2];
	      
        dp[1][1][0] = dp[1][1][1] = 1;
          
        for(int r = 1 ; r <= m ; ++r){
            for(int c = 1 ; c <= n ; ++c){
                if(cityMap[r - 1][c - 1] == 0){
                    dp[r][c][0] += (dp[r - 1][c][0] + dp[r][c - 1][1]) % MOD;
                    dp[r][c][1] += (dp[r - 1][c][0] + dp[r][c - 1][1]) % MOD;
                } 
                else if(cityMap[r - 1][c - 1] == 1){
                    dp[r][c][0] = 0;
                    dp[r][c][1] = 0;
                } 
                else {
                    dp[r][c][0] = dp[r - 1][c][0];
                    dp[r][c][1] = dp[r][c - 1][1];
                }
            }
        }
        return dp[m][n][1]; 
    }
}