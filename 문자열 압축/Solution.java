package 문자열압축;
import java.util.*;

public class Solution {
	 public int solution(String s) {
		    int answer = s.length();

		    for(int n=1 ; n<=s.length()/2 ; n++) {
		        StringBuilder temp = new StringBuilder();
		        
		        for(int i=0 ; i<s.length() ; i = i+n) {
		            String word = "";
		            
		            if(i+n >= s.length()) word = s.substring(i, s.length());
		            else word = s.substring(i, i+n);
		            
		            int cnt = 1;
		            StringBuilder sb = new StringBuilder();
		            
		            for(int j=i+n ; j<s.length() ; j=j+n) {
		                String word2 = "";
		                
		                if(j+n >= s.length()) {
		                    word2 = s.substring(j, s.length());
		                } else {
		                    word2 = s.substring(j, j+n);
		                }
		                
		                if(word.equals(word2)) {
		                    cnt++;
		                    i = j;
		                } else {
		                    break;
		                }
		            }
		            
		            if(cnt == 1) sb.append(word);
		            else sb.append(cnt).append(word);
		                            
		            temp.append(sb.toString());
		        }
		        //숫자로 길이 세고 추가하는 거보다는 StringBuilder로 저장하여 length로 비교하는게 좋은듯?

		        answer = Math.min(answer, temp.toString().length());
		    }

		    return answer;
		}
}
