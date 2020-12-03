import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
       // int le = 21;
        String[] anpart = skill.split("");
        //boolean[] check = new boolean[skill.length()];
        for(int i=0; i<skill_trees.length; i++){
            boolean[] check = new boolean[skill.length()];
            String[] tmp = skill_trees[i].split("");
            int cnt =0;
            int le = 1;
            int k=21;
            while(skill_trees[i].length()>cnt){
                for(int z=0; z<skill.length(); z++){
                    if(tmp[cnt].equals(anpart[z])){
                        k=z;
                        check[z]=true;
                        break;
                    }
                }
                if(0<=k && k<skill.length()){
                    for(int h=0; h<k; h++){
                        if(check[h]==false){
                            le=0;
                            break;
                        } 
                    }
                }
                
                if(le==0){
                    break;
                }
                cnt++;
                
            }
            if(skill_trees[i].length()==cnt){
                answer++;
            }
        }
        return answer;
    }
}