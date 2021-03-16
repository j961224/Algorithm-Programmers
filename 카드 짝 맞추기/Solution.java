import java.util.*;

class Solution {
    static ArrayList<int []> orders;
    static int[] xx = {-1,1,0,0};
    static int[] yy = {0,0,1,-1};
    public int solution(int[][] board, int r, int c) {
        int answer = Integer.MAX_VALUE;
        int n=0;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(board[i][j]!=0){
                    n++;
                }
            }
        }
        
        n/=2;
        int[] tmp = new int[n];
        for(int i=0; i<n; i++){
            tmp[i]=i+1;
        }
        
        orders=new ArrayList<>();
        permutation(n,n,tmp,0);
        for(int[] order : orders){
            int total=0;
            int[] initial = new int[2];
            initial[0]=r;
            initial[1]=c;
            
            int[][] cboard=new int[4][4];
            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    cboard[i][j]=board[i][j];
                }
            }
            
            for(int card : order){
                int cnt=0;
                
                cnt+=bfs(cboard,card,initial)+1;
                cboard[initial[0]][initial[1]]=0;
                
                cnt+=bfs(cboard,card,initial)+1;
                cboard[initial[0]][initial[1]]=0;
                
                total+=cnt;
            }
            answer=Math.min(answer,total);
        }
        
        return answer;
    }
    
    public static int bfs(int[][] cboard, int card, int[] initial){
        int r=initial[0];
        int c=initial[1];
        
        Queue<int[]> qu = new LinkedList<>();
        boolean[][] check = new boolean[4][4];
        
        qu.offer(new int[]{r,c,0});
        check[r][c]=true;
        
        while(!qu.isEmpty()){
            int[] tmp = qu.poll();
            if(cboard[tmp[0]][tmp[1]]==card){
                initial[0]=tmp[0];
                initial[1]=tmp[1];
                return tmp[2];
            }
            
            for(int i=0; i<4; i++){
                int tmpx=tmp[0]+xx[i];
                int tmpy=tmp[1]+yy[i];
                
                if(0<=tmpx && tmpx<4 && 0<=tmpy && tmpy<4){
                    if(!check[tmpx][tmpy]){
                        check[tmpx][tmpy]=true;
                        qu.add(new int[]{tmpx,tmpy,tmp[2]+1});
                    }
                }
            }
            
            for(int i=0; i<4; i++){
                int[] result = findCard(cboard,tmp[0],tmp[1],i);
                if((result[0]!=tmp[0] || result[1]!=tmp[1]) && !check[result[0]][result[1]]){
                    check[result[0]][result[1]]=true;
                    qu.add(new int[]{result[0],result[1],tmp[2]+1});
                }
            }
        }
        return 0;
    }
    
    public static int[] findCard(int[][] cboard,int r,int c,int d){
        r+=xx[d];
        c+=yy[d];
        while(0<=r && r<4 && 0<=c && c<4){
            if(cboard[r][c]!=0){
                return new int[]{r,c};
            }
            r+=xx[d];
            c+=yy[d];
        }
        return new int[]{r-xx[d],c-yy[d]};
    }
    
    public static void permutation(int n,int r,int[] tmp,int depth){
        if(depth==r){
            int[] temp1 = new int[n]; 
            temp1=tmp.clone();
            //System.arraycopy(tmp, 0, temp1, 0, n); //arraycopy가 빠르다, 부분 복사 가능
            orders.add(temp1);
            return;
        }
        
        for(int i=depth; i<n; i++){
            int tmp1=tmp[depth];
            tmp[depth]=tmp[i];
            tmp[i]=tmp1;
            permutation(n,r,tmp,depth+1);
            tmp1=tmp[depth];
            tmp[depth]=tmp[i];
            tmp[i]=tmp1;
        }
    }
}