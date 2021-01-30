import java.util.*;

class Solution {
    static HashMap<String,Integer> hm;
    public String[] solution(String[] orders, int[] course){
        ArrayList<String> ar = new ArrayList<>();
        for(int i =0;i<orders.length;i++){
            char[] charac = orders[i].toCharArray();
            Arrays.sort(charac);
            orders[i] = String.valueOf(charac);
        }
        
        
        for(int i=0; i<course.length; i++){
            hm = new HashMap<>();
            int max = -1;
            for(int j=0; j<orders.length; j++){
                if(course[i]<=orders[j].length()){
                    boolean[] visited = new boolean[orders[j].length()];
                    combination(orders[j],visited,0,course[i]);
                }
            }
            
            for(int k : hm.values()){
                if(max<k){
                    max=k;
                }
            }
            for(String k1 : hm.keySet()){
                
                if(max>=2 && hm.get(k1)==max){
                    ar.add(k1);
                }
            }
        }
        
        Collections.sort(ar);
        String[] answer = new String[ar.size()];
        for(int i=0; i<ar.size(); i++){
            answer[i]=ar.get(i);
        }
        
        return answer;
    }
    
    public static void combination(String arr, boolean[] visited, int start, int r) {
        if(r == 0) {
            summary(arr, visited);
            return;
        }
        
        for(int i=start; i<arr.length(); i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, r - 1);
            visited[i] = false;
            //combination(arr, visited, i + 1, r);
        }
    }
    
    public static void summary(String arr, boolean[] visited){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length(); i++){
            if(visited[i]){
                sb.append(arr.charAt(i));
            }
        }
        hm.put(sb.toString(),hm.getOrDefault(sb.toString(),0)+1);
    }
}