package prohash위장;
import java.util.*;
//각 종류에 +1을 해서 다 곱하여 마지막에 아무것도 선택하지 않는 경우(-1)을 해준다.

//명령어 : HashMap.getOrDefault(,) : 존재하는지 확인, HashMap.containsKey() : 이 요소가 존재하는 확인
//명령어 : HashMap.replace(,) : 전자에 원소가 있는 것을 후자 원소 변경
//명령어 : HashMap.values() : haspMap에 int요소 뽑기

public class Solution {
	public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(String[] a : clothes){
            if(hm.containsKey(a[1])){//종류를 이미 넣었는지 확인
                hm.replace(a[1],hm.get(a[1])+1); //종류가 존재하면 +1한 것으로 대체
            }
            else{
                hm.put(a[1],1);
            }
        }
        
        for(int b : hm.values()){
            answer *= (b+1);
        }
        answer -=1;
        
        return answer;
    }
}
