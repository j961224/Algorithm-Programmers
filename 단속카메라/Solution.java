package progreedy단속카메라;
import java.util.*;

public class Solution {
	public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, new Comparator<int []>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[0]-b[0]; // 진입지점 오름차순
            }
        });
        
        int tmp = routes[0][1];
        for(int i=0; i<routes.length; i++){
            if(routes[i][1]<tmp){
                tmp=routes[i][1];
            }
            if(routes[i][0]>tmp){
                tmp=routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}
