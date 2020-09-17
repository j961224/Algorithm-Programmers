package prograph����;
import java.util.*;

//ù ��° ����ó�� queue�� ó���� ���� �õ�
//�̰��� ������ => �������� INF�� ���� ��� ���� ������ ����⿡ ���� ���̵��
public class Solution {
	public int solution(int n, int[][] results) {
        int answer = 0;
        int INF=2000000;
        int distance[][]=new int[n+1][n+1];
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                distance[i][j]=INF;
            }
        }//��ü ��� �� ���Ѵ��
        
        for(int i=0; i<results.length; i++){
            distance[results[i][0]][results[i][1]]=1;
        }//����� �����ϴ� ��� 1��
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                for(int k=1; k<n+1; k++){
                    if(distance[j][k]>distance[j][i]+distance[i][k]){
                        distance[j][k]=distance[j][i]+distance[i][k];
                    }
                }
            }
        }//������ �� �ִ� ��� INF���� �ٸ� ������ ��ġ��
        
        for(int i=1; i<n+1; i++){
            boolean check = true;
            for(int j=1; j<n+1; j++){
                if(i==j) continue;
                if(distance[i][j] == INF && distance[j][i] == INF){
                    check=false;
                    break;
                }//�ϳ��� j�� ���� �� �� ���� ������ ���� ���� �� �ϹǷ� break
            }
            if(check) 
                answer++;
        }
        return answer;
    }
}
