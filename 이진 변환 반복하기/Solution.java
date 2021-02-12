import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        StringBuilder sb = new StringBuilder();
        int zerocnt=0;
        int step=0;
        while(s.length()!=1 || s.charAt(0)!='1'){
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='0'){
                    zerocnt++;
                }
                else if(s.charAt(i)=='1'){
                    sb.append("1");
                }
            }
            
            int len = sb.length();
            s = Integer.toBinaryString(len);
            sb = new StringBuilder();
            step++;
        }
        answer[0]=step;
        answer[1]=zerocnt;
        return answer;
    }
}