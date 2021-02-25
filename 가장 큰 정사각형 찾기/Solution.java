class Solution
{
    public int solution(int [][]board)
    {
        int answer=0;
        int[][] newboard = new int[board.length+1][board[0].length+1];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                newboard[i+1][j+1]=board[i][j];
            }
        }
        
        int max=0;
        for(int i=1; i<newboard.length; i++){
            for(int j=1; j<newboard[0].length; j++){
                if(newboard[i][j]==1){
                    int left=newboard[i][j-1];
                    int up = newboard[i-1][j];
                    int leftup=newboard[i-1][j-1];
                    int m = Math.min(left,Math.min(up,leftup));
                    newboard[i][j]=m+1;
                    max=Math.max(max,m+1);
                }
            }
        }
        answer=max*max;
        return answer;
    }
}