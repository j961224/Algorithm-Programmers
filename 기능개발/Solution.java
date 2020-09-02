package prostack��ɰ���;
//ù ��° ���̵��: queue�� progresses�� �� �־ progresses�� �� ���� ���ϰ� �տ��� 100�Ѵ� ��찡 ����� �װͶ� �ٷ� �̾����� �ڿ����� �ִ��� ���캸�� �ִ��� �������� ���� break�� ���(queue�� ������ ���� ���� ���� count�Ͽ� answer �迭�� �� �ڸ��� �־���) 
//=> ���� => answer ������ ũ��� ���� ���� �� ��

//�� ��° ���̵��: progresses�� �� ���� �� speeds�� ���ϰ� �� �� 100�� �Ѵ°� �տ��� ����� �ڿ����� �ִ��� ���캸�� ������ ���� ������ �ϰ� ���� ��츦 ã�� ��쿡 �ִ� �͵��� �� count�Ͽ� �� ������ queue�� �� �ڸ��� �ִ� ������ �ݺ��Ͽ� �� �˻��Ѵ�. 
//�׸��� queue�� poll�� �̿��Ͽ� answer�� �ֱ�
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
                while(k<progresses.length && progresses[k]>=100){//3��°�� k<progresses.length ���� �߰�
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
