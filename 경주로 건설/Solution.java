package ���ַΰǼ�;
import java.util.*;
//board �迭�� ������ ������ cost �����ϴ� ���̵� �� �ɸ� => �־�� �ϴ°� �ּҰ��� ���ؾ��ϹǷ�

public class Solution {
	static class Dot{
        int x;
        int y;
        int cost;
        int direction; //ó���� direction �� �־��µ� �� ������ queue�� ������ ������
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
        board[0][0]=1;//(0,0)���� �����ϴ� 1�� �ϰ� ���� �湮 X => ù ����Ʈ�� ���� �ٽ� ���ƿ��� �ʴ´�.
        
        while(!qu.isEmpty()){
            Dot tmp = qu.poll();
            if(tmp.x==board.length-1 && tmp.y==board.length-1){
                if(answer>tmp.cost){
                    answer=tmp.cost;
                    continue;
                }
            }
            for(int i=0; i<4; i++){//4���� ����
                int tx = tmp.x + xx[i];
                int ty = tmp.y + yy[i];
                if(0<=tx && tx<board.length && 0<=ty && ty<board.length && board[tx][ty] != 1){//���� �Ȱ� ���� ��� ����
                    int up = 0;
                    if(tmp.direction == -2 || tmp.direction ==i){//ó�� ������ (0,0)�̰ų� ���� ��� ������ �� ���� �����ΰ� üũ
                        up=tmp.cost+100;
                    }
                    else if(tmp.direction != i){//���� ������ �ƴ϶�� �ڳʷ� ���Ҵ�
                        up=tmp.cost+600;
                    }
                    
                    if(board[tx][ty]==0){
                        board[tx][ty]=up;//�ּҰ��� ���ϱ� ���� ó�� �湮 �� ����� cost�� board�� ����
                        qu.add(new Dot(tx,ty,up,i));
                    }
                    else if(board[tx][ty]>=up){//���� ����� cost�� �ּ��� �� board �迭 ���� -> �ּ����� ������ �̸� ��������� break ���� ����
                        board[tx][ty]=up;
                        qu.add(new Dot(tx,ty,up,i));
                    }
                    
                }
            }
        }
        
        
        return answer;
    }
}
