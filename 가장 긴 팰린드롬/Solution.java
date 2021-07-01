import java.util.*;

class Solution{
    public int solution(String s){
        int answer = 1;
        char[] ch = s.toCharArray();
        for(int len=s.length(); len>1; len--){
            for(int start=0; start+len<=s.length(); start++){
                boolean check = false;
                
                for(int i=0; i<len/2; i++){
                    if(ch[i+start]!=ch[len+start-i-1]){
                        check=true;
                        break;
                    }
                }
                
                if(!check){
                    return len;
                }
            }
        }
        
        return answer;
    }    
}