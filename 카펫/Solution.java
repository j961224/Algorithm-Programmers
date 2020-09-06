package profullsearch카펫;
import java.util.*;
//tmp*k=yellow와 (tmp+k)*2+4=brown 일 경우, tmp+2와 k+2가 답이다.(큰 수가 앞으로 오게 한다.)

public class Solution {
	public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int b = brown-4;
        int k=1;
        int tmp=0; int fin =0;
        while(k<=yellow){
            if((yellow%k)==0){
                tmp = yellow/k;
                fin = (tmp+k)*2;
                if(fin==b){
                    break;
                }
            }
            k++;
        }
        
        if(tmp>=k){
            answer[0]=tmp+2;
            answer[1]=k+2;
        }
        else{
            answer[0]=k+2;
            answer[1]=tmp+2;
        }
        
        return answer;
    }
}
