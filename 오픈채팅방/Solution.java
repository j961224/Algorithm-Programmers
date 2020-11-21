import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        //String[] answer = {};
        ArrayList<String> ar = new ArrayList<>();
        HashMap<String,String> hm = new HashMap<>();
        for(String k : record){
            String[] k1 = k.split(" ");
            if(k1[0].equals("Enter")){
                hm.put(k1[1],k1[2]);
                ar.add(k1[1]+"´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
            }
            if(k1[0].equals("Leave")){
                ar.add(k1[1]+"´ÔÀÌ ³ª°¬½À´Ï´Ù.");
            }
            if(k1[0].equals("Change")){
                hm.put(k1[1],k1[2]);
            }
        }
        
        String[] answer = new String[ar.size()];
        int cnt=0;
        for(String a : ar){
            int end = a.indexOf("´Ô");
            String user = a.substring(0,end);
            
            answer[cnt]=a.replace(user,hm.get(user));
            cnt++;
        }
        
        return answer;
    }
}