class Solution {
    public String solution(int n) {
        String answer = "";
        //n--;
        StringBuilder sb = new StringBuilder();
        while(true){
            //int tmp=0;
            int last=0;
            if(n==1 || n==2 || n==3){
                if(n==1){
                    sb.append("1");
                }
                if(n==2){
                    sb.append("2");
                }
                if(n==3){
                    sb.append("4");
                }
                break;
            }
            else{
                last=n%3;
                n=n/3;
                if(last==0){
                    sb.append("4");
                    n--;
                }
                if(last==1){
                    sb.append("1");
                }
                if(last==2){
                    sb.append("2");
                }
            }
        }
        
        for(int i=0; i<sb.length(); i++){
            answer+=Character.toString(sb.charAt(sb.length()-1-i));
        }
        return answer;
    }
}