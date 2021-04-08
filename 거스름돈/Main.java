class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[] dp = new int[1000001];
        dp[0]=1;
        for(int k : money){
            for(int j=k; j<=n; j++){
                dp[j]+=dp[j-k];
            }
        }
        answer=dp[n];
        return answer;
    }
}