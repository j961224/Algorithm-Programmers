import java.util.*;
class Solution {
    public int solution(String s) {
        //int answer = 0;
        String[] number = new String[10];
        number[0]="zero";
        number[1]="one";
        number[2]="two";
        number[3]="three";
        number[4]="four";
        number[5]="five";
        number[6]="six";
        number[7]="seven";
        number[8]="eight";
        number[9]="nine";
        StringBuilder sb = new StringBuilder();
        //int index=0;
        for(int i=0; i<s.length(); i++){
            int tmp = (int)s.charAt(i);
            boolean check = false;
            if(tmp>=48 && tmp<=57){
                sb.append(s.charAt(i));
                //index=i;
                check=true;
            }
            
            if(!check){
            for(int j=0; j<10; j++){
                if(s.substring(i,i+3).equals(number[j])){
                    sb.append(Integer.toString(j));
                    i+=2;
                    check=true;
                    break;
                }
            }
            }
            
            if(!check){
            for(int j=0; j<10; j++){
                if(s.substring(i,i+4).equals(number[j])){
                    sb.append(Integer.toString(j));
                    i+=3;
                    check=true;
                    break;
                }
            }
            }
            
            if(!check){
            for(int j=0; j<10; j++){
                if(s.substring(i,i+5).equals(number[j])){
                    sb.append(Integer.toString(j));
                    i+=4;
                    break;
                }
            }
            }
            
            // if(index>=s.length()){
            //     break;
            // }
        }
        
        return Integer.parseInt(sb.toString());
    }
}