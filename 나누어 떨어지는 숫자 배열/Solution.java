import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        
        for(int k : arr){
            if(k/divisor>=1 && k%divisor==0){
                arr1.add(k);
            }
        }
        
        if(arr1.size()==0){
            int[] answer=new int[1];
            answer[0]=-1;
            return answer;
        }
        
        int[] answer = new int[arr1.size()];
        for(int i=0; i<arr1.size(); i++){
            answer[i]=arr1.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}