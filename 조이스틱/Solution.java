package progreedy조이스틱;

public class Solution {
	public int solution(String name) {
        int answer = 0;
        int len = name.length();
        
        int minm = len - 1; 
        
        for(int i=0; i<len; i++){
            answer += Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1); //위, 아래로 가는 행동 중에 가장 최소인 것을 answer에 계속 더함
            
            int next = i+1;
            while(next<len && name.charAt(next)=='A'){ // 다음꺼에 A가 있다면 next를 늘려서 이동하지 않았다고 minm에 저장한다.
                next++;
            }
            minm = Math.min(minm, i+i+len-next);//minm은 왼쪽 오른쪽으로 이동한 것을 check
        }
        
        answer +=minm;
        
        return answer;
    }
}
