package progreedy체육복;
//지금 visit, visit1을 boolean 배열로 선언해서 썼더나느 것을 알렸는데 그냥 lost, reserve 배열에 방문하면 -1을 넣는 것이 용량에 효과적일꺼같다.
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
