package prostack기능개발;
//첫 번째 아이디어: queue에 progresses를 다 넣어서 progresses가 한 번씩 더하고 앞에서 100넘는 경우가 생기면 그것랑 바로 이어지는 뒤에꺼도 있는지 살펴보고 있는지 없는지에 따른 break를 사용(queue에 빠지는 수에 따른 숫자 count하여 answer 배열에 한 자리씩 넣었음) 
//=> 실패 => answer 가변적 크기로 인해 말이 안 됨

//두 번째 아이디어: progresses에 한 번씩 각 speeds를 더하고 난 뒤 100이 넘는게 앞에서 생기면 뒤에꺼도 있는지 살펴보고 있으면 없을 때까지 하고 없는 경우를 찾은 경우에 있는 것들을 다 count하여 그 정수를 queue의 한 자리에 넣는 식으로 반복하여 다 검사한다. 
//그리고 queue에 poll을 이용하여 answer에 넣기
public class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
        //int[] answer = {};
        Queue<Integer> st = new LinkedList<>();
        int k=0;
        
        while(k<progresses.length){
            int th=0;
            
            for(int j=k; j<progresses.length; j++){
                progresses[j]+=speeds[j];
            }
            
            
            if(progresses[k]>=100){
                while(k<progresses.length && progresses[k]>=100){//3번째에 k<progresses.length 조건 추가
                    k++;
                    th++;
                }
                st.add(th);
            }
            
            
        }
        int[] answer = new int[st.size()];
        for(int i=0; i<answer.length; i++){
            answer[i]=st.poll();
        }
        
        return answer;
    }
}
