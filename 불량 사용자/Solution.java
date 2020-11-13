package dd;

import java.util.*;

class Solution {
    static int userlen, banlen;
    static String[] user_id, banned_id;
    static boolean[] check;
    static HashSet<String> hs;
    
    public int solution(String[] User_id, String[] Banned_id) {
        int answer = 0;
        userlen=User_id.length;
        banlen=Banned_id.length;
        user_id=User_id;
        banned_id=Banned_id;
        
        check = new boolean[userlen];
        hs = new HashSet<>();
        
        dfs(0,"");
        answer=hs.size();
        return answer;
    }
    
    public void dfs(int cnt, String s){
        if(cnt == banlen){
            StringBuilder sb = new StringBuilder("");
            for(int i=0; i<userlen; i++){
                if(s.contains(""+i)){
                    sb.append(""+i);
                }
            }
            if(!hs.contains(sb.toString())){
                hs.add(sb.toString());
            }
            return;
        }
        
        for(int i=0; i<userlen; i++){
            if(check[i]){
                continue;
            }
            String k = banned_id[cnt].replace("*","."); //정규식 체크! => (*->.)
            
            if(user_id[i].matches(k)){
                check[i]=true;
                dfs(cnt+1,s+i);
                check[i]=false;
            }
        }
    }
}
