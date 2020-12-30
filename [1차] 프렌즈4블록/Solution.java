import java.util.*;
class Solution {
    static char[][] arr;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        arr = new char[m][n];
        //boolean[][] check = new check[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j]=board[i].charAt(j);
            }
        }
        
        while(true){
            boolean end = false;
            boolean[][] check = new boolean[m][n];
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    if(arr[i][j] != '.'){
                    char c = arr[i][j];
                    if(c==arr[i][j+1] && c==arr[i+1][j+1] && c==arr[i+1][j]){
                        end=true;
                        check[i][j]=check[i][j+1]=check[i+1][j+1]=check[i+1][j]=true;
                    }
                    }
                }
            }
            if(end==false){
                break;
            }
            else{
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(check[i][j]){
                        answer++;
                        arr[i][j]='.';
                    }
                }
            }
            down(m,n);
            }
        }
        return answer;
    }
    public static void down(int m, int n){ //원래 터진 열 부분만 아래로 땡길려고 했지만 이렇게 일단 구현
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(arr[i][j] != '.'){
                    int o=-1;
                    for(int r=m-1; r>i; r--){
                        if(arr[r][j]=='.'){
                            o=r;
                            break;
                        }
                    }
                    if(o!=-1){
                        char tmp = arr[i][j];
                        arr[i][j]=arr[o][j];
                        arr[o][j]=tmp;
                    }
                }
            }
        }
    }
}