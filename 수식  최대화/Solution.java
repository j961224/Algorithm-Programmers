
import java.util.*;
//dfs와 후위계산법으로 사용해서 계산한다
class Solution {
    static String exp;
    static long answer;
    static char[] opers;
    
    public long solution(String expression) {
        exp = expression;
        List<Character> li = new ArrayList<>();
        if(expression.contains("+")){
            li.add('+');
        }
        if(expression.contains("-")){
            li.add('-');
        }
        if(expression.contains("*")){
            li.add('*');
        }
        opers=new char[li.size()];
        for(int i=0; i<li.size(); i++){
            opers[i]=li.get(i);
        }
        answer = -1;
        dfs(0);
        return answer;
    }
    
    static void dfs(int n){
        if(n == opers.length){
            long tmp = cal();
            answer=Math.max(tmp,answer);
            return;
        }
        for(int i=n; i<opers.length; i++){
            swap(i,n);
            dfs(n+1);
            swap(i,n);
        }
    }
    
    static void swap(int i, int j){
        char c = opers[i];
        opers[i]=opers[j];
        opers[j]=c;
    }
    
    static long cal(){
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0; i<opers.length; i++){
            hm.put(Character.toString(opers[i]),i);
        }
        StringBuilder sb = new StringBuilder();
        List<String> equation = new ArrayList<>();
        Stack<String> arg = new Stack<>();
        for(int i=0; i<exp.length(); i++){
            char c = exp.charAt(i);
            if(c=='+' || c=='-' || c=='*'){
                equation.add(sb.toString());
                sb.delete(0,sb.length());
                while(!arg.isEmpty() && hm.get(Character.toString(c)) <= hm.get(arg.peek())){
                    equation.add(arg.pop());
                }
                arg.push(Character.toString(c));
            }
            else{
                sb.append(c);
            }
        }
        equation.add(sb.toString());
        while(!arg.isEmpty()){
            equation.add(arg.pop());
        }
        
        Stack<Long> value = new Stack<>();
        for(String e : equation){
            if(hm.containsKey(e)){
                long b = value.pop();
                long a = value.pop();
                if(e.equals("+")){
                    value.push(a+b);
                }
                if(e.equals("-")){
                    value.push(a-b);
                }
                if(e.equals("*")){
                    value.push(a*b);
                }
            }
            else{
                value.push(Long.parseLong(e));
            }
        }
        return Math.abs(value.pop());
    }
}
