package 보석쇼핑;
import java.util.*;

public class Solution {
	public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Queue<String> q = new LinkedList<>();
        HashMap<String,Integer> hm = new HashMap<>();
        HashMap<String,Integer> hs = new HashMap<>();
        
        int length = 1000000;
        for(String k : gems){
            if(!hs.containsKey(k)){
                hs.put(k,1);
            }
        }//hashSet을 써서 중복되는 부분 제거하여 중복 아닌 것만 넣어서 필요한 부분 다 들어갔는지 체크하기 위해서 크기 비교
        
        int sp = 0;
        int temp=0;
        for(int i=0; i<gems.length; i++){
            if(!hm.containsKey(gems[i])){
                hm.put(gems[i],1);
            }
            else{
                hm.put(gems[i],hm.get(gems[i])+1);
            }
            q.add(gems[i]);
            
            while(true){
                String k = q.peek();
                if(hm.get(k)>1){
                    q.poll();
                    temp++;
                    hm.put(k,hm.get(k)-1);
                }
                else{
                    break;
                }
            }
            if(hm.size()==hs.size() && length > q.size()){ //전자는 필요한 보석을 다 넣었는가와 후자는 필요한 보석들어간 길이 중에 제일 길이가 짧은 것 뽑기
                length=q.size();
                sp=temp;
            }
        }
        answer[0]=sp+1;
        answer[1]=sp+length;
        
        
        return answer;
    }
}
