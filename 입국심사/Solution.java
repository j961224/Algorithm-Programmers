package pro�Ա��ɻ�;
import java.util.*;
//ó�� �ð��� �ٸ� �ɻ������ �ּ� �ɸ��� �ð��� ���ϴ� ���� - �̺а˻�

public class Solution {
	public long solution(int n, int[] times) {
        Arrays.sort(times);
        long max = (long)times[times.length-1]*n;// �־��� ���
        long min = 1;//������ ���
        long mid = 0;
        long sum;
        long answer = max;
        while(min<=max){
            sum=0;
            mid=(min+max)/2;
            for(int t : times){
                sum += mid/t;
            }
            if(sum>=n){ //���� �ִ� ������� �� ���� �� �����Ƿ� �ð� ���̱�
                if(mid<answer){
                    answer=mid;
                }
                max = mid-1;
            }
            else{//�ƴϸ� �ð� �ø���
                min=mid+1;
            }
        }
        
        return answer;
    }
}
