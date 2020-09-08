package progreedy큰수만들기;
import java.util.*;
//처음에 다 하나씩 split로 잘라서 하나씩 쓸려고 했지만 다시 생각하여 반대로 다 들어가 있는 상태에서 하나씩 빼기로 생각했다.

public class Solution {
	public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        int delnum=0;
        int i = 1;
        
        while(delnum != k){
            if(i>=1 && sb.charAt(i-1)<sb.charAt(i)){//천천히 앞의 수가 뒤의 수보다 작으면 앞의 수를 삭제
                sb.deleteCharAt(i-1);
                i--;
                delnum++;
            }
            else{
                if(i==sb.length()-1 && sb.charAt(i)<=sb.charAt(i-1)){
                    sb.deleteCharAt(i);
                    i--;
                    delnum++;
                }
                else{
                    i++;
                }
            }
        }
        return sb.toString();
    }
}
