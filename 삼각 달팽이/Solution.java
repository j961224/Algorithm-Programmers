class Solution {
    static int[] xx = {1,0,-1};
    static int[] yy = {0,1,-1};
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] sol = new int[n][n];
        int t=0;
        
        if(n==1){
            answer[0]=1;
            return answer;
        }
        
        int direction=0;
        int x=-1;
        int y=0;
        int a=0;
        boolean check = false;
        while(true){
            for(int i=0; i<n; i++){
                x+=xx[direction%3];
                y+=yy[direction%3];
                if(0<=x && x<n && 0<=y && y<n){
                    if(sol[x][y]==0){
                        a++;
                        sol[x][y]=a;
                        if(a==n*(n+1)/2){
                            check=true;
                            break;
                        }
                    }
                    else{
                        x-=xx[direction%3];
                        y-=yy[direction%3];
                        direction++;
                        break;
                    }
                }
                else{
                    x-=xx[direction%3];
                    y-=yy[direction%3];
                    direction++;
                    break;
                }
            }
            if(check){
                break;
            }
        }
        int k1=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<i+1; j++){
                answer[k1]=sol[i][j];
                k1++;
            }
        }
        
        return answer;
    }
}