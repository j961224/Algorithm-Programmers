import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> ar = new ArrayList<>();
        while(true){
            if(n==2 || n==1){
                ar.add(n);
                break;
            }
            ar.add(n%3);
            n/=3;
        }
        
        int r=1;
        for(int i=0; i<ar.size(); i++){
            answer+=r*ar.get(ar.size()-1-i);
            r*=3;
        }
        return answer;
    }
}