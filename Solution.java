package 비밀지도;

import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        //Integer.toBinaryString(num);
        for(int i=0; i<n; i++){
            String arr11 = Integer.toBinaryString(arr1[i]);
            String arr22 = Integer.toBinaryString(arr2[i]);
            char[] ch1 = new char[n];
            char[] ch2 = new char[n];
            Arrays.fill(ch1,'0');
            Arrays.fill(ch2,'0');
            for(int b=0; b<arr11.length(); b++){
                ch1[n-arr11.length()+b]=arr11.charAt(b);
            }
            for(int b=0; b<arr22.length(); b++){
                ch2[n-arr22.length()+b]=arr22.charAt(b);
            }
            
            
            StringBuilder sb = new StringBuilder();
            for(int k=0; k<n; k++){
                if(ch1[k]=='1' || ch2[k]=='1'){
                    sb.append("#");
                }
                else{
                    sb.append(" ");
                }
            }
            answer[i]=sb.toString();
        }
        return answer;
    }
}
