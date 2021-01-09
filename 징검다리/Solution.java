import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left=1;
        int mid;
        int right=distance;
        int lastrock=0;
        int remove=0;
        Arrays.sort(rocks);
        while(left<=right){
            mid=(left+right)/2;
            for(int i=0; i<rocks.length; i++){
                if(mid>rocks[i]-lastrock){ //거리 최솟값 벗어나면 제거
                    remove++;
                }
                else{
                    lastrock=rocks[i]; // 안 벗어나면 다음 rock저장
                }
            }
            
            if(mid>distance-lastrock){ // 마지막 꺼 check
                remove++;
            }
            
            if(remove>n){ //제거한 돌이 제거할 정해진 돌 수보다 많다면
                right=mid-1;
            }
            else{
                answer=Math.max(answer,mid);
                left=mid+1;
            }
            remove=0;
            lastrock=0;
        }
        
        return answer;
    }
}