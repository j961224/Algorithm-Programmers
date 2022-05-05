import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Set<String> drop_duplicates_report = new HashSet<String>();
        HashMap<String,Integer> id_cnt = new HashMap<>();
        
        // 중복 제거
        for(int i=0; i<report.length; i++){
            drop_duplicates_report.add(report[i]);
        }
        
        // 횟수 count 
        Iterator<String> it = drop_duplicates_report.iterator();
        while(it.hasNext()){
            String tmp = it.next();
            id_cnt.put(tmp.split(" ")[1],id_cnt.getOrDefault(tmp.split(" ")[1],0)+1);
        }
        
        it = drop_duplicates_report.iterator();
        while(it.hasNext()){
            String tmp = it.next();
            if(id_cnt.containsKey(tmp.split(" ")[1]) && id_cnt.get(tmp.split(" ")[1])>=k){
                answer[Arrays.asList(id_list).indexOf(tmp.split(" ")[0])]+=1;
            }
        }
        
        return answer;
    }
}
