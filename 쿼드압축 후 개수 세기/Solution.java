class Solution {
    static int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        int size=arr.length;
        dfs(size,0,0,arr);
        return answer;
    }
    
    public static void dfs(int size,int x, int y,int[][] arr){
        if(size==1){
            if(arr[x][y]==1){
                answer[1]+=1;
            }
            else{
                answer[0]+=1;
            }
            return;
        }
        
        boolean check=true;
        int k = arr[x][y];
        for(int i=x; i<x+size; i++){
            if(check){
                for(int j=y; j<y+size; j++){
                    if(k != arr[i][j]){
                        check=false;
                        break;
                    }
                }
            }
            else{
                break;
            }
        }
        
        if(check){ //일치하는 부분은 재귀 돌릴 시, 섞이지 않도록 if문에서 끝내준다.
            if(k==1){
                answer[1]+=1;
            }
            else{
                answer[0]+=1;
            }
        }
        else{
            size/=2;
            dfs(size,x+size,y,arr);
            dfs(size,x,y+size,arr);
            dfs(size,x,y,arr);
            dfs(size,x+size,y+size,arr);
        }
    }
}