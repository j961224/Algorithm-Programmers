class Solution {
    public int solution(int n) {
        int answer = 0;
        int tmp=n;
        while(true){
            if(tmp==0){
                break;
            }
            if(n%tmp==0){
                answer+=tmp;
            }
            tmp--;
        }
        
        return answer;
    }
}