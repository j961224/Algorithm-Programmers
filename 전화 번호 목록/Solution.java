package prohash전화번호목록;
import java.util.*;
//startsWith으로 괄호 안에 들어가는 String으로 시작하는지 비교 후 들어가면 true


public class Solution {
	public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        
        for(int i=0; i<phone_book.length; i++){
            for(int j=i+1; j<phone_book.length; j++){
                if(phone_book[j].startsWith(phone_book[i])){
                    return false;
                }
            }
        }
        return true;
    }

}
