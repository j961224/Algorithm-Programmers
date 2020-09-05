package prohash����;
import java.util.*;
//�� ������ +1�� �ؼ� �� ���Ͽ� �������� �ƹ��͵� �������� �ʴ� ���(-1)�� ���ش�.

//��ɾ� : HashMap.getOrDefault(,) : �����ϴ��� Ȯ��, HashMap.containsKey() : �� ��Ұ� �����ϴ� Ȯ��
//��ɾ� : HashMap.replace(,) : ���ڿ� ���Ұ� �ִ� ���� ���� ���� ����
//��ɾ� : HashMap.values() : haspMap�� int��� �̱�

public class Solution {
	public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(String[] a : clothes){
            if(hm.containsKey(a[1])){//������ �̹� �־����� Ȯ��
                hm.replace(a[1],hm.get(a[1])+1); //������ �����ϸ� +1�� ������ ��ü
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
