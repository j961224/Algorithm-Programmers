import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int sizeof = nums.length/2;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i],1);
        }
        if(sizeof<hm.size()){
            answer=sizeof;
        }
        else if(hm.size()<=sizeof){
            answer=hm.size();
        }
        
        return answer;
    }
}