package 크레인인형뽑기게임;
import java.util.*;

public class Solution {
	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<moves.length; i++){
            int move = moves[i]-1;
            int tmp=0;
            for(int k=0; k<board.length ; k++){
                if(board[k][move] != 0){
                    tmp = board[k][move]; 
                    board[k][move]=0;
                    break;
                }
            }
            if(tmp !=0){
                if(st.size()==0){
                    st.push(tmp);
                }
                else{
                    if(st.peek()==tmp){
                        st.pop();
                        answer=answer+2;
                    }
                    else{
                        st.push(tmp);
                    }
                }
            }
        }
        return answer;
    }
}
