package profullsearchī��;
import java.util.*;
//tmp*k=yellow�� (tmp+k)*2+4=brown �� ���, tmp+2�� k+2�� ���̴�.(ū ���� ������ ���� �Ѵ�.)

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
