package progreedyü����;
//���� visit, visit1�� boolean �迭�� �����ؼ� ������� ���� �˷ȴµ� �׳� lost, reserve �迭�� �湮�ϸ� -1�� �ִ� ���� �뷮�� ȿ�����ϲ�����.
public class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        boolean[] visit = new boolean[reserve.length];
        boolean[] visit1 = new boolean[lost.length];
        int tmp1=0;
        int k=0;
        
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    visit[j]=true;
                    visit1[i]=true;
                    k++;
                    break;
                }
            }
        }
        int tmp = n-lost.length+k;
        
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if((lost[i]-1)==reserve[j] && visit[j]==false && visit1[i]==false){
                    visit[j]=true;
                    visit1[i]=true;
                    tmp1++;
                    break;
                }
                else if((lost[i]+1)==reserve[j] && visit[j]==false && visit1[i]==false){
                    visit[j]=true;
                    visit1[i]=true;
                    tmp1++;
                    break;
                }
            }
        }
        answer=tmp+tmp1;
        
        return answer;
    }
}
