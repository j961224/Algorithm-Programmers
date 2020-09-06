package profullsearch���ǰ��;
import java.util.*;
//player�� 3������ �����̰� ���� ���� ���� ������ �־����ִ�.

// �ٸ� ������� �ڵ带 �� �غ����� �� �ð����⵵�� �� �ڵ尡 �� �ɷ����� �������⵵�δ� ����ϴ�.

public class Solution {
	class player implements Comparable<player>{
        int playernumber;
        int correctnumber;
        player(int playernumber, int correctnumber){
            this.playernumber = playernumber;
            this.correctnumber = correctnumber;
        }
        
        @Override
        public int compareTo(player k){
            if(k.correctnumber == this.correctnumber){//���� ������ ���ٸ� player ���� ��ȣ ��������
                return this.playernumber-k.playernumber;
            }
            else{
                return k.correctnumber-this.correctnumber;//���� ������ ���� ������ ��������
            }
        }
    }
    
    public int[] solution(int[] answers) {
        //int[] answer = {};
        
        int[] math1 = {1,2,3,4,5};
        int[] math2 = {2,1,2,3,2,4,2,5};
        int[] math3 = {3,3,1,1,2,2,4,4,5,5};
        int correct1=0;
        int correct2=0;
        int correct3=0;
        ArrayList<player> P = new ArrayList<>();
        
        for(int i=0; i<answers.length; i++){
            if(math1[i%5]==answers[i]){
                correct1++;
            }
            if(math2[i%8]==answers[i]){
                correct2++;
            }
            if(math3[i%10]==answers[i]){
                correct3++;
            }
            if(i==(answers.length-1)){
                P.add(new player(1,correct1));
                P.add(new player(2,correct2));
                P.add(new player(3,correct3));
            }
        }
        
        Collections.sort(P,new Comparator<player>(){
            @Override
            public int compare(player p1, player p2){
                return p1.compareTo(p2);
            }
        });
        
        int maxn=0;//�ִ밪�� ��� ������ �ִ���
        int max=0;//max�� ����
        for(player u : P){
            if(max==0){
                max=u.correctnumber;
                maxn++;
            }
            else{
                if(max==u.correctnumber){
                    maxn++;
                }
                else{
                    break;
                }
            }
        }
        int[] answer = new int[maxn];
        int o=0;
        for(player b : P){
            if(maxn>o){
                answer[o]=b.playernumber;
                o++;
            }
            else{
                break;
            }
        }
        
                         
        
        return answer;
    }
}
