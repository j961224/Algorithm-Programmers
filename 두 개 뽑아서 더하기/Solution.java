import java.util.*;

class Solution {
    static ArrayList<Integer> ar = new ArrayList<>();
    public int[] solution(int[] numbers) {
        Collec(numbers);
        Collections.sort(ar);
        int[] answer = new int[ar.size()];
        for(int i=0; i<ar.size(); i++){
            answer[i]=ar.get(i);
        }
        return answer;
    }
    
    public static void Collec(int[] numbers){
        for(int i=0; i<numbers.length; i++){
            for(int j=0; j<numbers.length; j++){
                if(i!=j){
                    int tmp=numbers[i]+numbers[j];
                    if(!ar.contains(tmp)){
                        ar.add(tmp);
                    }
                }
            }
        }
    }
}