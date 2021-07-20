import java.util.*;
class Dot{
    int x;
    int y;
    int dist;
    public Dot(int x, int y, int dist){
        this.x=x;
        this.y=y;
        this.dist=dist;
    }
}

class Solution {
    static int[] xx = {-1,1,0,0};
    static int[] yy = {0,0,1,-1};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i=0; i<places.length; i++){
            boolean check1 = true;
            for(int j=0; j<places[i].length; j++){
                String tmp = places[i][j];
                for(int z=0; z<tmp.length(); z++){
                    if(tmp.charAt(z)=='P' && check1){
                        Queue<Dot> qu = new LinkedList<>();
                        boolean[][] check = new boolean[5][5];
                        qu.add(new Dot(j,z,0));
                        while(!qu.isEmpty()){
                            Dot tmp1 = qu.poll();
                            check[tmp1.x][tmp1.y]=true;
                            int d = tmp1.dist;
                            if(!check1){
                                break;
                            }
                            for(int k=0; k<4; k++){
                                int tmpx = tmp1.x+xx[k];
                                int tmpy = tmp1.y+yy[k];
                                if(tmpx>=0 && tmpx<5 && tmpy>=0 && tmpy<5){
                                    if(!check[tmpx][tmpy] && d<2){
                                        if(places[i][tmpx].charAt(tmpy)=='O'){
                                            check[tmpx][tmpy]=true;
                                            qu.add(new Dot(tmpx,tmpy,d+1));
                                        }
                                        else if(places[i][tmpx].charAt(tmpy)=='P'){
                                            check[tmpx][tmpy]=true;
                                            check1=false;
                                            break;
                                        }
                                        else if(places[i][tmpx].charAt(tmpy)=='X'){
                                            check[tmpx][tmpy]=true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                
            }
            
            if(check1){
                answer[i]=1;
            }
            else{
                answer[i]=0;
            }
        }
        
        
        return answer;
    }
}