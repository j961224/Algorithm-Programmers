import java.util.*;

class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        int tmp=0;
        int k = Math.min(w,h);
        for(int i=k; i>0; i--){
            if(w%i==0 && h%i==0){
                tmp=i;
                break;
            }
        }
        
        answer = (long)w*(long)h-((((long)w/tmp)+((long)h/tmp)-1)*tmp);
        
        return answer;
    }
}