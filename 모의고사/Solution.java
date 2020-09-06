package profullsearch모의고사;
import java.util.*;
//player는 3명으로 고정이고 각각 찍은 답은 패턴이 주어져있다.

// 다른 사람과의 코드를 비교 해보았을 때 시간복잡도는 내 코드가 더 걸렸지만 공간복잡도로는 비슷하다.

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
            if(k.correctnumber == this.correctnumber){//맞춘 갯수가 같다면 player 고유 번호 오름차순
                return this.playernumber-k.playernumber;
            }
            else{
                return k.correctnumber-this.correctnumber;//맞춘 개수가 많은 순으로 내림차순
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
        
        int maxn=0;//최대값을 몇명 가지고 있는지
        int max=0;//max값 저장
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
