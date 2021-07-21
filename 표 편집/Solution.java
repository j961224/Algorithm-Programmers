import java.util.*;
//sb.insert로 이름마다의 고유 index 해결 가능
//=> C가 2번 연속와서 index 혼동 생길 일 X
class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> st = new Stack<>();
        int size=n;
        for(int i=0; i<cmd.length; i++){
            char c = cmd[i].charAt(0);
            if(c=='U'){
                k-=Integer.parseInt(cmd[i].substring(2,cmd[i].length()));
            }
            else if(c=='D'){
                k+=Integer.parseInt(cmd[i].substring(2,cmd[i].length()));
            }
            else if(c=='C'){
                st.push(k);
                size-=1;
                if(k==size){
                    k-=1;
                }
            }
            else{
                int zz = st.pop();
                if(k>=zz){
                    k+=1;
                }
                size+=1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++){
            sb.append('O');
        }
        while(!st.isEmpty()){
            sb.insert(st.pop().intValue(),'X');
        }
        return sb.toString();
    }
}