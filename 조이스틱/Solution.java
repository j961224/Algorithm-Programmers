package progreedy���̽�ƽ;

public class Solution {
	public int solution(String name) {
        int answer = 0;
        int len = name.length();
        
        int minm = len - 1; 
        
        for(int i=0; i<len; i++){
            answer += Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1); //��, �Ʒ��� ���� �ൿ �߿� ���� �ּ��� ���� answer�� ��� ����
            
            int next = i+1;
            while(next<len && name.charAt(next)=='A'){ // �������� A�� �ִٸ� next�� �÷��� �̵����� �ʾҴٰ� minm�� �����Ѵ�.
                next++;
            }
            minm = Math.min(minm, i+i+len-next);//minm�� ���� ���������� �̵��� ���� check
        }
        
        answer +=minm;
        
        return answer;
    }
}
