package progreedy섬연결하기;
import java.util.*;

public class Solution {
	public int solution(int n, int[][] costs) {
        Comparator<int[]> c1 = (a,b) ->{
            return a[2]-b[2]; //다리 건설 비용 오름차순
        };
        
        Arrays.sort(costs,c1);
        boolean[] bridge = new boolean[costs.length]; //점 사이의 다리 건설 유무
        boolean[] visit = new boolean[n]; //점을 방문한 유무
        
        visit[costs[0][0]]=true;
        visit[costs[0][1]]=true;
        bridge[0]=true;
        int answer = costs[0][2];
        int island = 2; //처음에 costs[0,1], cost[0,0] 2개를 방문한 상태에서 시작하므로
        
        while(island<n){
            for(int i=1; i<costs.length; i++){
                if(!bridge[i] && ((visit[costs[i][0]] && !visit[costs[i][1]]) || !visit[costs[i][0]] && visit[costs[i][1]])){
                    bridge[i]=true;
                    visit[costs[i][0]] = true;
                    visit[costs[i][1]] = true;
                    island++;
                    answer += costs[i][2];
                    break;
                }
            }
        }
        return answer;
    }
}
