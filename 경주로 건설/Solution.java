package 경주로건설;
import java.util.*;
//board 배열에 지나갈 때마다 cost 저장하는 아이디어가 좀 걸림 => 넣어야 하는게 최소값을 구해야하므로

public class Solution {
	static class Dot{
        int x;
        int y;
        int cost;
        int direction; //처음에 direction 안 넣었는데 안 넣으니 queue가 돌수록 난리남
        Dot(int x, int y, int cost, int direction){
            this.x=x;
            this.y=y;
            this.cost=cost;
            this.direction = direction;
        }
    }
    
    static int[] xx = {-1,1,0,0};
    static int[] yy = {0,0,-1,1};
    
    public int solution(int[][] board) {
        int answer = 1000000000;
        
        Queue<Dot> qu = new LinkedList<Dot>();
        //int[][] direction = new int[board.length][board.length];
        //direction[0][0]=-1;
        qu.add(new Dot(0,0,0,-2));
        board[0][0]=1;//(0,0)부터 시작하니 1로 하고 이제 방문 X => 첫 포인트는 굳이 다시 돌아오지 않는다.
        
        while(!qu.isEmpty()){
            Dot tmp = qu.poll();
            if(tmp.x==board.length-1 && tmp.y==board.length-1){
                if(answer>tmp.cost){
                    answer=tmp.cost;
                    continue;
                }
            }
            for(int i=0; i<4; i++){//4방향 ㄱㄱ
                int tx = tmp.x + xx[i];
                int ty = tmp.y + yy[i];
                if(0<=tx && tx<board.length && 0<=ty && ty<board.length && board[tx][ty] != 1){//범위 안과 벽일 경우 제외
                    int up = 0;
                    if(tmp.direction == -2 || tmp.direction ==i){//처음 시작한 (0,0)이거나 원래 계속 진행할 때 가던 방항인가 체크
                        up=tmp.cost+100;
                    }
                    else if(tmp.direction != i){//가던 방향이 아니라면 코너로 돌았다
                        up=tmp.cost+600;
                    }
                    
                    if(board[tx][ty]==0){
                        board[tx][ty]=up;//최소값을 비교하기 위한 처음 방문 시 계산한 cost를 board에 저장
                        qu.add(new Dot(tx,ty,up,i));
                    }
                    else if(board[tx][ty]>=up){//새로 계산한 cost가 최소일 때 board 배열 갱신 -> 최소이지 않으면 미리 끊어버리는 break 같은 존재
                        board[tx][ty]=up;
                        qu.add(new Dot(tx,ty,up,i));
                    }
                    
                }
            }
        }
        
        
        return answer;
    }
}
