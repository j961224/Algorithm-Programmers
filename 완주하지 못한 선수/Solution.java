package prohash�����������Ѽ���;
import java.util.*;
//�������� ����, ������ ���� �����Ͱ� �и��ų� ���ڸ��� ä��� ���� �̵��ؾ� �ϱ� ������ ���� �ð��� �ҿ�ȴ�. 
//=> �̷� �Ѱ踦 �غ��ϱ� ���� ���Ǵ� ���� hash

public class Solution {
	 public String solution(String[] participant, String[] completion) {
	        String answer="";
	        HashMap<String,Integer> hm = new HashMap<String,Integer>();
	        
	        for(String a : participant){
	            hm.put(a,hm.getOrDefault(a,0)+1);//getOrDefault�� ���� a�� �����Ѵٸ� 1�� return�ϰ� ������ 0�� return
	        }
	        
	        int val;
	        for(String b : completion){//completion �迭�� �ִ� ���Ҹ� -1�� ���� �ش�.
	            val=hm.get(b)-1;
	            hm.put(b,val);
	        }
	        
	        for(String c : hm.keySet()){// c�� integer�� 0�̸� completion�� �����ϴ� ���̰� 1�̸� �ߺ��ǰų� ���� ���Ҹ� �ǹ��Ѵ�.
	            if(hm.get(c)==1)
	                answer=c;
	        }
	        
	        return answer;
	    }
}
