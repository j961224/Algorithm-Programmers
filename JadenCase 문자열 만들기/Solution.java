import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        String[] tmp = s.toLowerCase().split(" ");
        for(int i=0; i<tmp.length; i++){
            //공백이 있다면 그냥 공백으로 저장해야한다.
            if("".equals(tmp[i])){
                answer.append("");
            }
            else if(tmp[i].length()==1){
                answer.append(Character.toUpperCase(tmp[i].charAt(0)));
            }
            else{
                answer.append(Character.toUpperCase(tmp[i].charAt(0))+tmp[i].substring(1));
            }
            if(i!=tmp.length-1){
                answer.append(" ");
            }
        }
        
        //마지막에 띄어쓰기가 있다면 그대로 넣어줘야한다.
        if(" ".equals(s.substring(s.length()-1,s.length()))){
            answer.append(" ");
        }
        
        return answer.toString();
    }
}
