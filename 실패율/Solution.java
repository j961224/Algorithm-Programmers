package 실패율;
import java.util.*;

public class Solution {
	class failure implements Comparable{
        int cnt;
        double fail;
        
        failure(int cnt, double fail){
            this.cnt=cnt;
            this.fail=fail;
        }
        
        @Override
        public int compareTo(Object f){
            failure f1 = (failure) f;
            if(f1.fail == this.fail){
                return Integer.compare(this.cnt,f1.cnt);//스테이지는 오름차순
            }
            else{
                return -Double.compare(this.fail,f1.fail); // 실패율은 내림차순
            }
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Queue<failure> qu = new PriorityQueue<>();
        Arrays.sort(stages);
        
        int i=1;
        int size=stages.length;
        int trial = 0;
        while(N>=i){
            int cc=0;
            double an = 0.0;
            for(int k=trial; k<stages.length; k++){
                if(i==stages[k]){
                    cc++;
                }
                else{
                    break;
                }
            }
            if(cc!=0 && size!=0){
                an = (double)cc/size;
            }
            qu.add(new failure(i,an));
            i++;
            size-=cc;
            trial+=cc;
        }
        
        for(int p=0; p<N; p++){
            failure kk = qu.poll();
            answer[p]=kk.cnt;
        }
        
        return answer;
    }
}
