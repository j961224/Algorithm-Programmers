import java.util.*;

class Solution {
    static int[] answer;
    public int[] solution(int n, int s) {
        if(n>s){
            answer = new int[1];
            answer[0]=-1;
            return answer;
        }
        
        answer = new int[n];
        for(int i=0; i<answer.length; i++){
            answer[i]=s/n;
        }
        for(int i=0; i<s%n; i++){
            answer[i]+=1;
        }
        Arrays.sort(answer);
        return answer;
    }
}