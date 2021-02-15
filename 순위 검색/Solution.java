import java.util.*;

class Solution {
    //static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static Map<String,ArrayList<Integer>> map = new HashMap<>();
    static int[] answer;
    
    public static void dfs(String str,int cnt,String[] infomation){
        if(cnt==4){
            if(!map.containsKey(str)){
                ArrayList<Integer> li = new ArrayList<>();
                li.add(Integer.parseInt(infomation[4]));
                map.put(str,li);
            }
            else{
                map.get(str).add(Integer.parseInt(infomation[4]));
            }
            return;
        }
        dfs(str+"-",cnt+1,infomation);
        dfs(str+infomation[cnt],cnt+1,infomation);
    }
    public static void setInfo(String[] info){
        for(int i=0; i<info.length; i++){
            dfs("",0,info[i].split(" "));
        }
        Iterator<String> li = map.keySet().iterator();
        while(li.hasNext()){
            String k = li.next();
            ArrayList<Integer> a = map.get(k);
            Collections.sort(a);
        }
    }
    
    public static int countof(String str, int target){
        if(!map.containsKey(str)){
            return 0;
        }
        ArrayList<Integer> al = map.get(str);
        int low = 0, high = al.size(), mid;
        while(low < high) {
            mid = low + (high - low)/2;
            if(target<=map.get(str).get(mid))
                high=mid;
            else
                low = mid + 1;
        }
        return al.size()-low;
    }
    
    public static void takeAnswer(String[] query){
        for(int i=0; i<query.length; i++){
            String str="";
            String[] sp = query[i].split(" ");
            
            for(int j=0; j<sp.length-1; j++){
                if(!sp[j].equals("and")){
                    str+=sp[j];
                }
            }
            
            answer[i]=countof(str,Integer.parseInt(sp[sp.length-1]));
        }
    }
    
    public int[] solution(String[] info, String[] query) {
        answer = new int[query.length];
        setInfo(info);
        takeAnswer(query);
        return answer;
    }
}
