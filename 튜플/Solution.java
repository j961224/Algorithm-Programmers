import java.util.*;

class Solution {
    class tuple implements Comparable<tuple>{
        String s1;
        int trial;
        tuple(String s1, int trial){
            this.s1=s1;
            this.trial=trial;
        }
        
        @Override
        public int compareTo(tuple o){
            return o.trial-this.trial;
        }
        
    }
    
    public int[] solution(String s) {

        s = s.substring(2, s.length()-2).replace("},{", "-");

String [] arr = s.split("-");
Arrays.sort(arr, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
});

ArrayList<Integer> list = new ArrayList<>();
for(String temp : arr) {
    String [] val = temp.split(",");
    
    for(int i=0 ; i<val.length ; i++) {
        int num = Integer.valueOf(val[i]);
        
        if(!list.contains(num)) {
            list.add(num);
        }
    }
}

int [] answer = new int[list.size()];
for(int i=0 ; i<list.size() ; i++) {
    answer[i] = list.get(i);
}

return answer;
    }
}