package prosortHindex;
import java.util.*;
//내림차순으로 했을 때, 배열에서 i+1번째에 i 숫자인 경우 => for 문이 많고 시간이 많이 걸림
//-> 오름차순으로 생각(한 index의 원소 수가 남은 index 수 이상일 경우 check)

public class Solution {
	public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        for(int i=0; i<citations.length; i++){
            if(citations[i]>=citations.length-i){
                //answer=citations[i]; -> 2차
                answer=citations.length-i;
                break;
            }
        }
        return answer;
    }
}
