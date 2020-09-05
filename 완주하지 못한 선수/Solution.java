package prohash완주하지못한선수;
import java.util.*;
//데이터의 삽입, 삭제시 많은 데이터가 밀리거나 빈자리를 채우기 위해 이동해야 하기 때문에 많은 시간이 소요된다. 
//=> 이런 한계를 극복하기 위해 사용되는 것이 hash

public class Solution {
	 public String solution(String[] participant, String[] completion) {
	        String answer="";
	        HashMap<String,Integer> hm = new HashMap<String,Integer>();
	        
	        for(String a : participant){
	            hm.put(a,hm.getOrDefault(a,0)+1);//getOrDefault를 통해 a가 존재한다면 1을 return하고 없으면 0을 return
	        }
	        
	        int val;
	        for(String b : completion){//completion 배열에 있는 원소면 -1을 더해 준다.
	            val=hm.get(b)-1;
	            hm.put(b,val);
	        }
	        
	        for(String c : hm.keySet()){// c에 integer이 0이면 completion에 존재하는 것이고 1이면 중복되거나 없는 원소를 의미한다.
	            if(hm.get(c)==1)
	                answer=c;
	        }
	        
	        return answer;
	    }
}
