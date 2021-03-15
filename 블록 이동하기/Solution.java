import java.util.*;
class Robot{
    int x;
    int y;
    int fx;
    int fy;
    int dir;
    int time;
    Robot(int x, int y,int fx, int fy, int dir, int time){
        this.x=x;
        this.y=y;
        this.fx=fx;
        this.fy=fy;
        this.dir=dir;
        this.time=time;
    }
}

class Main{
    static int[] dx = {0,1,0,-1}; 
    static int[] dy = {1,0,-1,0};
    static int[] rdx= {-1,1,1,-1};
    static int[] rdy= {1,1,-1,-1};
    static int N;
    
    public static void main(String[] args){
        int[][] board={{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
        N=board.length;
        int min1 = Integer.MAX_VALUE;
        boolean[][][] check =  new boolean[N][N][4];
        Queue<Robot> qu = new LinkedList<>();
        qu.add(new Robot(0,0,0,1,0,0));
        check[0][0][0]=true;
        
        while(!qu.isEmpty()){
            Robot tmp = qu.poll();
            
            if((tmp.x==N-1 && tmp.y==N-1) || (tmp.fx==N-1 && tmp.fy==N-1)){
                min1=Math.min(tmp.time,min1);
                break;
            }
            
            for(int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                int fnx = tmp.fx+dx[i];
                int fny = tmp.fy+dy[i];
                
                if(0<=nx && nx<N && 0<=ny && ny<N && 0<=fnx && fnx<N && fny<N && fny>=0){
                    if(board[nx][ny]==0 && board[fnx][fny]==0 && !check[nx][ny][tmp.dir]){
                        check[nx][ny][tmp.dir]=true;
                        qu.add(new Robot(nx,ny,fnx,fny,tmp.dir,tmp.time+1));
                    }
                }
            }
            
            
            for(int i=1; i<4; i+=2){
                int dir = (tmp.dir+i)%4;
                int nx = tmp.x+dx[dir];
                int ny = tmp.y+dy[dir];
                int tmpdir=0;
                if(i==1){
                    tmpdir=dir;
                }
                else{
                    tmpdir=tmp.dir;
                }
                
                int rx = tmp.x+rdx[tmpdir];
                int ry = tmp.y+rdy[tmpdir];
                if(0<=nx && nx<N && 0<=ny && ny<N && 0<=rx && rx<N && ry<N && ry>=0){
                    if(board[nx][ny]==0 && board[rx][ry]==0 && !check[tmp.x][tmp.y][dir]){
                        check[tmp.x][tmp.y][dir]=true;
                        qu.add(new Robot(tmp.x,tmp.y,tmp.x+dx[dir],tmp.y+dy[dir],dir,tmp.time+1));
                    }
                }
            }
            
            int dir1=(tmp.dir+2)%4;
            for(int i=1; i<4; i+=2){
                int dir = (dir1+i)%4;
                int nx = tmp.fx+dx[dir];
                int ny = tmp.fy+dy[dir];
                int tmpdir=0;
                if(i==1){
                    tmpdir=dir;
                }
                else{
                    tmpdir=dir1;
                }
                
                int rx = tmp.fx+rdx[tmpdir];
                int ry = tmp.fy+rdy[tmpdir];
                
                dir=(dir+2)%4;
                if(0<=nx && nx<N && 0<=ny && ny<N && 0<=rx && rx<N && ry<N && ry>=0){
                    if(board[nx][ny]==0 && board[rx][ry]==0 && !check[nx][ny][dir]){
                        check[nx][ny][dir]=true;
                        qu.add(new Robot(nx,ny,nx+dx[dir],ny+dy[dir],dir,tmp.time+1));
                    }
                }
            }
        }
        
        System.out.println(min1);
        
    }
}