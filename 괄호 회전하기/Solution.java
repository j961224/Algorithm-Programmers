import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int leng = s.length();
        
        for(int i=0; i<leng; i++){
            if(i!=0){
                String tmp1 = s.substring(0,1);
                String tmp2 = s.substring(1,s.length());
                s = tmp2+tmp1;
            }
            Stack<String> st = new Stack<>();
            boolean check = true;
            for(int j=0; j<leng; j++){
                String tmp=s.substring(j,j+1);
                if(tmp.equals("(") || tmp.equals("[") || tmp.equals("{")){
                    st.push(tmp);
                }
                else{
                    if(!st.isEmpty()){
                        if(st.peek().equals("(") && tmp.equals(")")){
                            st.pop();
                        }
                        else if(st.peek().equals("[") && tmp.equals("]")){
                            st.pop();
                        }
                        else if(st.peek().equals("{") && tmp.equals("}")){
                            st.pop();
                        }
                    }
                    else{
                        check=false;
                        break;
                    }
                }
            }
            
            if(st.isEmpty() && check){
                answer+=1;
            }
        }
        return answer;
    }
}