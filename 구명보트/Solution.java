package progreedy����Ʈ;
import java.util.*;

public class Solution {
	public int solution(int[] people, int limit) {
        int answer = 0;
        int j=0;
        Arrays.sort(people);
        
        int i=0;
        for(i=people.length-1; i>j; i--){
            if(people[j]+people[i]<=limit){ //�ִ� 2����� �¿� �� �����Ƿ�
                j++;
                answer++;
            }
            else{
                answer++;
            }
        }
        
        if(i==j){ // ������ �� �� ����
            answer++;
        }
        return answer;
    }
}
