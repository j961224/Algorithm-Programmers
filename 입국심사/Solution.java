package pro입국심사;
import java.util.*;
//처리 시간이 다른 심사원들의 최소 걸리는 시간을 구하는 문제 - 이분검색

public class Solution {
	public long solution(int n, int[] times) {
        Arrays.sort(times);
        long max = (long)times[times.length-1]*n;// 최악의 경우
        long min = 1;//최적의 경우
        long mid = 0;
        long sum;
        long answer = max;
        while(min<=max){
            sum=0;
            mid=(min+max)/2;
            for(int t : times){
                sum += mid/t;
            }
            if(sum>=n){ //원래 있는 사람보다 더 맡을 수 있으므로 시간 줄이기
                if(mid<answer){
                    answer=mid;
                }
                max = mid-1;
            }
            else{//아니면 시간 늘리기
                min=mid+1;
            }
        }
        
        return answer;
    }
}
