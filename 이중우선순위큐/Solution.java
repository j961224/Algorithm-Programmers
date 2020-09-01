package proheap이중우선순위큐;
import java.util.*;

//첫 아이디어는 D를 이용하여 최대값, 최소값을 삭제하여야 하므로 D가 나올때마다 실시간으로 오름차순이 된 queue를 이용하기 위해서 우선순위큐 적용 

//그러나 'D 1'일 경우 우선순위큐로 적용 가능하지만 'D -1'일 경우에는 우선순위큐는 오름차순이 기본인데 내림차순으로 한 번 정렬하는 수고로움이 생김

//따라서 'I 숫자' 나올경우만 ArrayList에 넣어서 정렬하고 'D 1 or -1'이 나오면 그 때에 맞춰서 맨 끝이나 맨 처음 숫자를 제거해주는 아이디어로 생각

public class Solution {
	public int[] solution(String[] operations) {
        int[] answer = {0,0};
        ArrayList<Integer> ar = new ArrayList<Integer>(); // 최대값이나 최소값을 빼야하니 queue는 쓰지 않았다.(정렬하면 맨 뒤나 맨 앞 골라서 빼야하므로 대중적인거 선택)
        for(int i=0; i<operations.length; i++){
            String[] parts = operations[i].split(" ");//요소에 띄어쓰기 기점으로 2개로 나눌 때 쓴다.
            //출처:https://stackoverflow.com/questions/3481828/how-to-split-a-string-in-java
            if(parts[0].equals("I")){ // 'I'일 경우마다 오름차순을 한다.
                ar.add(Integer.parseInt(parts[1]));
                Collections.sort(ar); //Arrays.sort는 말그대로 array(int[]) 이럴 때 쓰인다. => 크기가 얼마나 되는지 모르는 list 같은 경우에 Collections를 쓰게 된다.
            }
            
            if(parts[0].equals("D") && !ar.isEmpty()){ // 'D'일 경우마다 하나 원소를 뺀다.
                if(parts[1].equals("1")){
                    ar.remove(ar.size()-1);
                }
                if(parts[1].equals("-1")){
                    ar.remove(0);
                }
            }
        }
        if(!ar.isEmpty()){
            answer[0]=ar.get(ar.size()-1); //최소값 출력 
            answer[1]=ar.get(0); //최대값 출력
        }
        
        return answer;
    }
}
