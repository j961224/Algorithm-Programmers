import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        //1단계
        StringBuilder sb = new StringBuilder(new_id.toLowerCase());
        
        //2단계
        StringBuilder tmp = new StringBuilder();
        for(int i=0; i<sb.length(); i++){
            if((97<=(int)sb.charAt(i) && (int)sb.charAt(i)<=122) || (int)sb.charAt(i) ==45 || (int)sb.charAt(i)==46 || (int)sb.charAt(i)==95 || ((int)sb.charAt(i)>=48 && (int)sb.charAt(i)<=57)){
                tmp.append(sb.charAt(i));
            }
        }
        
        //3단계
        StringBuilder tmp1 = new StringBuilder();
        for(int i=0; i<tmp.length(); i++){
            if(tmp.charAt(i)!='.'){
                tmp1.append(tmp.charAt(i));
            }
            else{
                while(true){
                    i++;
                    if(i==tmp.length()){
                        tmp1.append('.');
                        break;
                    }
                    else if(tmp.charAt(i)!='.'){
                        tmp1.append('.').append(tmp.charAt(i));
                        break;
                    }
                }
            }
        }
        
        answer=tmp1.toString();
        //4단계
        while(true){
            if(answer.startsWith(".")){
                answer=answer.substring(1);
            }
            else{
                break;
            }
        }
        while(true){
            if(answer.endsWith(".")){
                answer=answer.substring(0,answer.length()-1);
            }
            else{
                break;
            }
        }
        
        //5단계
        tmp1=new StringBuilder(answer);
        if(tmp1.length()==0){
            tmp1.append("a");
        }
        answer=tmp1.toString();
        //6단계
        if(answer.length()>=16){
            answer=answer.substring(0,15);
        }
        while(true){
            if(answer.endsWith(".")){
                answer=answer.substring(0,answer.length()-1);
            }
            else{
                break;
            }
        }
        
        //7단계
        tmp1=new StringBuilder(answer);
        if(tmp1.length()==1){
            tmp1.append(tmp1.charAt(0)).append(tmp1.charAt(0));
        }
        if(tmp1.length()==2){
            tmp1.append(tmp1.charAt(1));
        }
        
        answer=tmp1.toString();
        return answer;
    }
}