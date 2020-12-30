import java.util.*;

class Solution {
    static boolean[] check;
    static ArrayList<String> answers;
    public String[] solution(String[][] tickets) {
        answers = new ArrayList<>();
        check = new boolean[tickets.length];
        int count = 0;
        dfs(count,"ICN","ICN",tickets);
        Collections.sort(answers);
        String[] answer = answers.get(0).split(" ");
        return answer;
    }
    public static void dfs(int count, String present, String next, String[][] tickets){
        if(count==tickets.length){
            answers.add(next);
            return;
        }
        for(int i=0; i<tickets.length; i++){
            if(!check[i] && tickets[i][0].equals(present)){
                check[i]=true;
                dfs(count+1,tickets[i][1],next+" "+tickets[i][1],tickets);
                check[i]=false;
            }
        }
        return;
    }
}