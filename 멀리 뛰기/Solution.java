import java.util.*;
class Solution {
    public long solution(int n) {
        long[] dp = new long[n+1];
        if(n<2){
            return 1;
        }
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        
        for(int i=3; i<dp.length; i++){
            long tmp=dp[i-1]+dp[i-2];
            dp[i]=tmp%1234567;
        }
        return dp[n]%1234567;
    }
    
}