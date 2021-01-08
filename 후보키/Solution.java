import java.util.*;

class Solution {
    static ArrayList<HashSet<Integer>> col;
    public int solution(String[][] relation) {
        col = new ArrayList<HashSet<Integer>>();
        dfs(0,new HashSet<Integer>(),relation);
        return col.size();
    }
    
    public static void dfs(int posi, HashSet<Integer> select, String[][] relation){
        if(posi == relation[0].length){
            for(int i=0; i<col.size(); i++){
                if(select.containsAll(col.get(i))){
                    return;
                }
            }
            
            HashSet<String> tmp = new HashSet<>();
            for(int i=0; i<relation.length; i++){//유일성 검사
                String tmp1 = "";
                for(int c : select){
                    tmp1+= relation[i][c];
                }
                if(tmp.contains(tmp1)){//겹치는 게 있다면 바로 아웃
                    return;
                }
                tmp.add(tmp1);
            }
            
            col.add(select);
            return;
        }
        
        HashSet<Integer> c1 = new HashSet<>();
        HashSet<Integer> c2 = new HashSet<>();
        for(Integer val : select){
            c1.add(val);
            c2.add(val);
        }
        dfs(posi+1,c1,relation);
        c2.add(posi);//다른 하나의 dfs에게는 posi번 col도 넣어준다
        dfs(posi+1,c2,relation);
        
    }
}