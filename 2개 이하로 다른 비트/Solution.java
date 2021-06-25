import java.util.*;
//이와 다른 방식을 시도했지만 테스트 10,11이 시간초과로 통과되지 않음

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            long tmp = numbers[i];
            String s = Long.toBinaryString(tmp); //numbers의 숫자를 이진법으로 바꾼 string
            
            //짝수라면 맨 마지막 자리가 이진법으로 표현했을 때 0이므로 거기에 +1하면 답임
            if(numbers[i]%2==0){
                answer[i]=numbers[i]+1;
            }
            //홀수라면
            else{
                //0이 있는 위치들 중에 가장 뒤에 0의 위치
                int lastindex = s.lastIndexOf("0");
                //lastindex위치 뒤에 가장 가까운 1을 0으로 바꿔주면 2번 이하로 바꾸는 것 중에 원래 숫자보다는 크지만 그 중에서 작은 숫자가 나온다.
                int firstindex = s.indexOf("1",lastindex);
                
                //0에 위치된 것이 없다면
                if(lastindex==-1){
                    numbers[i]+=1;
                    s = Long.toBinaryString(numbers[i]);
                    s=s.substring(0,2)+s.substring(2,s.length()).replace("0","1");
                }
                else{
                    s = s.substring(0,lastindex)+"1"+s.substring(lastindex+1,firstindex)+"0"+s.substring(firstindex+1,s.length());
                }
                answer[i]=Long.parseLong(s,2);
            }
        }
        
        return answer;
    }
    
    public boolean check(String s, String s1){
        boolean check1 = false;
        int check2 = 0;
        if(s.length()==s1.length()){
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)!=s1.charAt(i)){
                    check2+=1;
                }
            }
        }
        else{
            int z = s1.length()-s.length();
            check2+=z;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)!=s1.charAt(z+i)){
                    check2+=1;
                }
            }
        }
        
        if(check2<=2){
            check1=true;
        }
        return check1;
    }
}