import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        for(int i=0; i<answer.length; i++){
            answer[i]=0;
        }
        
        Map<String,String> tree = new HashMap<>();
        Map<String,Integer> enrolls = new HashMap<>();
        
        for(int i=0; i<enroll.length; i++){
            tree.put(enroll[i],referral[i]);
            enrolls.put(enroll[i],i);
        }
        
        for(int i=0; i<seller.length; i++){
            String sell = seller[i];
            int amounts = amount[i]*100;
            
            while(!sell.equals("-")){
                int poster = amounts-(amounts/10);
                int rest = amounts/10;
                
                answer[enrolls.get(sell)]+=poster;
                sell = tree.get(sell);
                amounts=rest;
                if(amounts<1){
                    break;
                }
            }
        }
        
        return answer;
    }
}