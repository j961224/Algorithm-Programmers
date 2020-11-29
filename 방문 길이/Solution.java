import java.util.*;

class Solution {
    // U,D,R,L - ��,�Ʒ�,������,���� ��
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {-1, 1, 0, 0};
    // ���� ũ�� = -5 ~ 5�����̹Ƿ� 11x11
    public static boolean[][][][] visit = new boolean[11][11][11][11];
    public int solution(String dirs) {
        int answer = 0;
        
        /* x,y = ĳ���Ͱ� �̵��ϱ� �� ��ġ, nextX, nextY = ĳ���Ͱ� �̵��� �� ��ġ */
        int x = 0;
        int y = 0;
        // ������ ������ -5~5�̰�, �迭��ũ���0~10�̹Ƿ� ���� ��ġ�� +5�� ����ش�.
        int nextX = 5;
        int nextY = 5;
        
        int index = 0;
        
        for(int i=0; i<dirs.length(); i++){
            // ĳ������ ���� ��ġ ����
            x = nextX;
            y = nextY;
            if(dirs.charAt(i) == 'U') 
                index = 0;
            else if(dirs.charAt(i) == 'D')  
                index = 1;
            else if(dirs.charAt(i) == 'R')  
                index = 2;
            else if(dirs.charAt(i) == 'L')  
                index = 3;
            
            // U, D, R, L�� �´� ĳ���� ��ġ �̵�
            nextX += dx[index];
            nextY += dy[index];
            
            // ������ ������ ������ ���� ĳ������ ��ġ�� ������ ����� ���
            if(nextX < 0 || nextY < 0 || nextX > 10 || nextY > 10){
                // �ٽ� ĳ���͸� ���� ��ġ�� �̵�
                nextX -= dx[index];
                nextY -= dy[index];
                continue;
            }
            
            // ĳ���Ͱ� ó�� �ɾ ���ϰ��
            if(!visit[x][y][nextX][nextY] && !visit[nextX][nextY][x][y]){
                // �ɾ�� �� üũ(���� �ƴ� ���̱� ������ ��������� üũ�Ѵ�.)
                visit[x][y][nextX][nextY] = true;
                visit[nextX][nextY][x][y] = true;
                answer ++;
            }
        }
        return answer;
    }
}