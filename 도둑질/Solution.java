class Solution {
    public int solution(int[] money) {
        int answer = 0;
        if(money.length<=3){
            for(int i=0; i<money.length; i++){
                answer = Math.max(answer,money[i]);
            }
            return answer;
        }
        int[] dp = new int[money.length];
        int[] dp1 = new int[money.length];
        
        dp[0]=money[0];
        dp[1]=money[0];
        dp1[0]=0;
        dp1[1]=money[1];
        
        for(int i=2; i<money.length-1; i++){
            dp[i]=Math.max(dp[i-2]+money[i],dp[i-1]);
            dp1[i]=Math.max(dp1[i-2]+money[i],dp1[i-1]);
        }
        
        int index = money.length-1;
        dp[index] = Math.max(dp[index-1],dp[index-2]);
        dp1[index] = Math.max(dp1[index-2]+money[index],dp1[index-1]);
        
        answer = Math.max(dp[index],dp1[index]);
        return answer;
    }
}