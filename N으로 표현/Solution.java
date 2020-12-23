import java.util.*;

class Solution {
    //static int answer;
    static int min = -1;
    public int solution(int N, int number) {
        int answer = 0;
        dfs(N,0,number,0);
        return min;
    }
    public void dfs(int N1, int answer, int number1, int target1){
        int temp = N1;
        if(target1==number1){
            if(min>answer || min==-1){
                min=answer;
            }
        }
        if(answer>8){
            min=-1;
        }
        else{
            for(int i=0; i<8-answer; i++){
                dfs(N1,answer+1+i,number1,target1-temp);
                dfs(N1,answer+1+i,number1,target1+temp);
                dfs(N1,answer+1+i,number1,target1*temp);
                dfs(N1,answer+1+i,number1,target1/temp);
                temp=temp*10+N1;
            }
            
        }
    }
}