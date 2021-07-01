class Solution {
    public int solution(int n) {
        int answer = 1; //n 자기 자신일 때는 무조건 가능하므로
        
        for(int i=1; i<n; i++){
            int tmp=i;
            for(int j=i+1; j<n; j++){
                tmp+=j;
                if(tmp>n){
                    break;
                }
                else if(tmp==n){
                    answer+=1;
                    break;
                }
            }
        }
        return answer;
    }
}