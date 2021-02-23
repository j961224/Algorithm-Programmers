class Solution {
    public String solution(String s) {
        String answer = "";
        String[] tmp = s.split(" ");
        int max=-1000000;
        int min=1000000;
        
        for(int i=0; i<tmp.length; i++){
            int tmp1 = Integer.parseInt(tmp[i]);
            if(max<tmp1){
                max=tmp1;
            }
            if(min>tmp1){
                min=tmp1;
            }
        }
        answer= Integer.toString(min)+" "+ Integer.toString(max);
        return answer;
    }
}