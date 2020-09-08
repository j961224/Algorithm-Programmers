package progreedy구명보트;
import java.util.*;

public class Solution {
	public int solution(int[] people, int limit) {
        int answer = 0;
        int j=0;
        Arrays.sort(people);
        
        int i=0;
        for(i=people.length-1; i>j; i--){
            if(people[j]+people[i]<=limit){ //최대 2명까지 태울 수 있으므로
                j++;
                answer++;
            }
            else{
                answer++;
            }
        }
        
        if(i==j){ // 마지막 한 명 남음
            answer++;
        }
        return answer;
    }
}
