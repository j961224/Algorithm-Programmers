package ��������;
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
        }//hashSet�� �Ἥ �ߺ��Ǵ� �κ� �����Ͽ� �ߺ� �ƴ� �͸� �־ �ʿ��� �κ� �� ������ üũ�ϱ� ���ؼ� ũ�� ��
        
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
            if(hm.size()==hs.size() && length > q.size()){ //���ڴ� �ʿ��� ������ �� �־��°��� ���ڴ� �ʿ��� ������ ���� �߿� ���� ���̰� ª�� �� �̱�
                length=q.size();
                sp=temp;
            }
        }
        answer[0]=sp+1;
        answer[1]=sp+length;
        
        
        return answer;
    }
}
