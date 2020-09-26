package 뉴스클러스터링;
import java.util.*;

public class Solution {
	public int solution(String str1, String str2) {
        int intersection = 0;
        int answer;
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        
        int max = Math.max(str1.length(),str2.length());
        for(int i=0; i<max-1; i++){
            if(i<str1.length()-1 && Character.isLetter(str1.charAt(i)) && Character.isLetter(str1.charAt(i+1))){
                arr1.add(str1.substring(i,i+1).toLowerCase()+str1.substring(i+1,i+2).toLowerCase());
            }
            if(i<str2.length()-1 && Character.isLetter(str2.charAt(i)) && Character.isLetter(str2.charAt(i+1))){
                arr2.add(str2.substring(i,i+1).toLowerCase()+str2.substring(i+1,i+2).toLowerCase());
            }
        }
        
        int size1 = arr1.size();
        int size2 = arr2.size();
        for(String stri : arr1){
            if(arr2.contains(stri)){
                intersection++;
                arr2.remove(stri);
            }
        }
        int union = size1+size2-intersection;
        if(union == 0 && intersection == 0){
            answer = 65536;
        }
        else{
            answer = (int)(65536 * (intersection/(double)union));
        }
        
        return answer;
    }
}
