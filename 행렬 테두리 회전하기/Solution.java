import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] tmp = new int[rows][columns];
        int[][] copying = new int[rows][columns];
        int c=1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                tmp[i][j]=c;
                copying[i][j]=c;
                c+=1;
            }
        }
        
        for(int i=0; i<queries.length; i++){
            int a = Integer.MAX_VALUE;
            int x1=queries[i][0]-1;
            int y1=queries[i][1]-1;
            int x2=queries[i][2]-1;
            int y2=queries[i][3]-1;
            
            for(int j=y1; j<y2; j++){
                tmp[x1][j+1]=copying[x1][j];
                a=Math.min(a,copying[x1][j]);
            }
            
            for(int j=x1; j<x2; j++){
                tmp[j+1][y2]=copying[j][y2];
                a=Math.min(a,copying[j][y2]);
            }
            
            for(int j=y2; j>y1; j--){
                tmp[x2][j-1]=copying[x2][j];
                a=Math.min(a,copying[x2][j]);
            }
            
            for(int j=x2; j>x1; j--){
                tmp[j-1][y1]=copying[j][y1];
                a=Math.min(a,copying[j][y1]);
            }
            answer[i]=a;
            for(int j=0; j<rows; j++) {
                for(int k=0; k<columns; k++) {
                    copying[j][k] = tmp[j][k];  
                }
            }
        }
        return answer;
    }
}