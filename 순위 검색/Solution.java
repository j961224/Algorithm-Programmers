import java.util.*;

class Solution {
    static ArrayList<String> arrli = new ArrayList<>();
    static ArrayList<Integer> arrli1 = new ArrayList<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        //ArrayList<String> query1 = new ArrayList<>();
        //ArrayList<Integer> query2 = new ArrayList<>();
        // for(int i=0; i<query.length; i++){
        //     String[] tmp = query[i].split(" and ");
        //     String[] tmp1 = tmp[3].split(" ");
        //     query1.add(tmp[0]+tmp[1]+tmp[2]+tmp1[0]);
        //     query2.add(Integer.parseInt(tmp1[1]));
        // }
        
        for(int i=0; i<info.length; i++){
            String[] tmp1 = info[i].split(" ");
            combination(tmp1);
        }
        
        
        HashMap<String, ArrayList<Integer>> hm = new HashMap<String, ArrayList<Integer>>();
        int q=0;
        for (int i = 0; i < arrli.size(); i++) {
            String key = arrli.get(i);
            if(i!=0 && i%16==0){
                q++;
            }
            int score=arrli1.get(q);
            ArrayList<Integer> list = new ArrayList<Integer>();
            if (hm.containsKey(key)){
               // 이미 해당 key가 맵에 있을 때에는 value를 불러온 뒤 넣음
               list = hm.get(key);
               list.add(score);
               Collections.sort(list);
               //hm.replace(key,hm.get(key),list);
            } 
            else if(!hm.containsKey(key)){
                // 맵에 key가 없다면 새로 value를 추가
                list.add(score);
                //hm.put(key,list);
            }
            hm.put(key,list);
        }
        
        
        for(int i=0; i<query.length; i++){
            String[] tmp1 = query[i].split(" and ");
            String[] tmp2 = tmp1[3].split(" ");
            String tmp = tmp1[0]+tmp1[1]+tmp1[2]+tmp2[0];
            
            int start = Integer.parseInt(tmp2[1]);
            int answering=0;
            if (hm.containsKey(tmp)) {
                int low = 0, high = hm.get(tmp).size(), mid;
                while(low < high) {
                    mid = low + (high - low)/2;
                    if(start<=hm.get(tmp).get(mid))
                        high=mid;
                    else
                        low = mid + 1;
                }
                answering=hm.get(tmp).size()-low;
            }
            answer[i]=answering;
        }
        
        return answer;
    }
    
    public static void combination(String[] tmp1){
        arrli.add(tmp1[0]+tmp1[1]+tmp1[2]+tmp1[3]);
        arrli.add("-"+tmp1[1]+tmp1[2]+tmp1[3]);
        arrli.add(tmp1[0]+"-"+tmp1[2]+tmp1[3]);
        arrli.add(tmp1[0]+tmp1[1]+"-"+tmp1[3]);
        arrli.add(tmp1[0]+tmp1[1]+tmp1[2]+"-");
        arrli.add("-"+"-"+tmp1[2]+tmp1[3]);
        arrli.add("-"+tmp1[1]+"-"+tmp1[3]);
        arrli.add("-"+tmp1[1]+tmp1[2]+"-");
        arrli.add(tmp1[0]+"-"+"-"+tmp1[3]);
        arrli.add(tmp1[0]+"-"+tmp1[2]+"-");
        arrli.add(tmp1[0]+tmp1[1]+"-"+"-");
        arrli.add("-"+tmp1[1]+"-"+"-");
        arrli.add("-"+"-"+"-"+tmp1[3]);
        arrli.add("-"+"-"+tmp1[2]+"-");
        arrli.add(tmp1[0]+"-"+"-"+"-");
        arrli.add("-"+"-"+"-"+"-");
        arrli1.add(Integer.parseInt(tmp1[4]));
    }
}