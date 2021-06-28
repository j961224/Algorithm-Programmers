//dp 사용
class Solution {
    public int solution(int sticker[]) {
        int answer=0;
        if(sticker.length<=3){
            for(int i=0; i<sticker.length; i++){
                answer = Math.max(sticker[i],answer);
            }
            return answer;
        }
        int[] dp = new int[sticker.length]; //마지막 index 포함 X
        int[] dp1 = new int[sticker.length]; //마지막 index 포함
        dp[0]=sticker[0];
        dp[1]=sticker[0];
        dp1[0]=0;
        dp1[1]=sticker[1];
        for(int i=2; i<sticker.length-1; i++){
            dp[i]=Math.max(dp[i-2]+sticker[i],dp[i-1]);
            dp1[i]=Math.max(dp1[i-2]+sticker[i],dp1[i-1]);
        }
        
        int index = sticker.length-1;
        dp[index] = Math.max(dp[index-2],dp[index-1]);
        dp1[index] = Math.max(dp1[index-2]+sticker[index],dp1[index-1]);
        
        answer = Math.max(dp[index],dp1[index]);
        return answer;
    }
}