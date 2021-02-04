import java.util.*;

class Dot{
    int x;
    int y;
    int area;
    public Dot(int x,int y, int area){
        this.x=x;
        this.y=y;
        this.area=area;
    }
}

class Solution {
    static int[] xx = {-1,1,0,0};
    static int[] yy = {0,0,1,-1};
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    if(picture[i][j]!=0){
                        numberOfArea++;
                        int tmpsize=0;
                        Queue<Dot> qu = new LinkedList<>();
                        qu.add(new Dot(i,j,picture[i][j]));
                        visited[i][j]=true;
                        while(!qu.isEmpty()){
                            Dot tmp = qu.poll();
                            tmpsize++;
                            for(int k=0; k<4; k++){
                                int tmpx = tmp.x+xx[k];
                                int tmpy = tmp.y+yy[k];
                                if(0<=tmpx && tmpx<m && 0<=tmpy && tmpy<n && picture[tmpx][tmpy]==tmp.area && !visited[tmpx][tmpy]){
                                    visited[tmpx][tmpy]=true;
                                    qu.add(new Dot(tmpx,tmpy,tmp.area));
                                }
                            }
                        }
                        if(maxSizeOfOneArea<tmpsize){
                            maxSizeOfOneArea=tmpsize;
                        }
                    }
                }
            }
        }
        
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}