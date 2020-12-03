import java.util.*;

class Solution {
    
    public static boolean wordCompare(String currentword, String word){
        if(currentword.charAt(currentword.length()-1)==word.charAt(0)){
            return true;
        }
        return false;
    }
    
    public static void trueman(boolean[] check, String[] words, String target){
        for(int p=0; p<words.length; p++){
            if(target.equals(words[p])){
                check[p]=true;
            }
        }
    }
    
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        boolean[] check = new boolean[words.length];
        int tmptrial =1;
        
        for(int i=0; i<words.length; i++){
            if(i != words.length-1){
                if(wordCompare(words[i],words[i+1])==true && check[i]==false && check[i+1]==false){
                    tmptrial++;
                    trueman(check,words,words[i]);
                }
                else{
                    break;
                }
            }
            else{
                break;
            }
        }
        
        if(tmptrial==words.length){
            answer[0]=0;
            answer[1]=0;
        }
        else{
            if((tmptrial+1)%n==0){
                answer[0]=n;
                answer[1]=(tmptrial+1)/n;
            }
            else{
                answer[0]=(tmptrial+1)%n;
                answer[1]=((tmptrial+1)/n)+1;
            }
        }
        

        return answer;
    }
}