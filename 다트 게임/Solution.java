import java.util.*;

class Solution {
    public int solution(String dartResult) {
        char[] darts = dartResult.toCharArray();
        int[] answer = new int[3];
        
        int cnt = -1;
        for(int i=0; i<dartResult.length(); i++){
            if(dartResult.charAt(i)>='0' && dartResult.charAt(i)<='9'){
                cnt++;
                if(dartResult.charAt(i)=='1' && dartResult.charAt(i+1)=='0'){
                    answer[cnt]=10;
                    i++;
                }
                else{
                    answer[cnt]=dartResult.charAt(i) - '0';
                }
            }
            else if(dartResult.charAt(i)=='D'){
                answer[cnt]*=answer[cnt];
            }
            else if(dartResult.charAt(i)=='T'){
                answer[cnt]*=answer[cnt]*answer[cnt];
            }
            else if(dartResult.charAt(i)=='#'){
                answer[cnt]*=(-1);
            }
            else if(dartResult.charAt(i)=='*'){
                answer[cnt]*=2;
                if(cnt != 0){
                    answer[cnt-1]*=2;
                }
            }
            
        }
        return answer[0]+answer[1]+answer[2];
    }
}
