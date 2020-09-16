package proDFSBFS단어변환;
//1. 첫번째 bfs로 하는데 횟수랑 단어를 따로 코드를 짯는데 아래와 같은 에러를 제외한게 흠이었다.
//==> 처음에 bfs에 node라는 int를 생각 안 하고 해서 그런가...

//hit에서 선별해 hot이 나오고 hot으로 한 번 훑어서 dot, lot이 나오는데 횟수를 같은 2로 저장하고 queue로 돌려서 check했는지에 따라 queue에 dot 다음 lot을 자연스럽게 넘기고 다음 비슷한 것을 횟수 하나씩 늘림 => 횟수랑 단어랑 같이 저장하는 것이 중요! => 이유는 queue 넣을때마다 횟수 하나씩 늘리면 최소 단계의 과정을 못 만듦 
//이렇게 queue로 해서 lot을 넣어서 횟수로는 안 치지만 넣어서 비교해서 dog 다음에 log가 안 나오도록 해야한다. => 그러므로 queue(횟수, 그에 해당하는 단어)로 생각한다.

//횟수랑 word 묶어서 생각
import java.util.*;

public class Solution {
	static class wordset{
        String word;
        int trial;
        
        wordset(int trial, String word){
            this.trial=trial;
            this.word=word;
        }
    }
    
    //문자 하나만 다른지 확인
    public static boolean wordCompare(String convertword, String word){
        int count = 0;
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i)!=convertword.charAt(i)){
                count++;
            }
            if(count>1){
                return false;
            }
        }
        return true;
    }
    
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        //List<String> word = Arrays.asList(words);//word string 당 배열에 한 word씩 list로 저장
        int[] check = new int[words.length];
        
        for(int i=0; i<words.length; i++){
            check[i]=0;
        }
        int r=0;
        for(int i=0; i<words.length; i++){ //애초에 words 배열에 같은 단어가 없었을 때
            if(words[i].contains(target)){ //contains으로 문자열 여부 확인(string의 list.contains(string)도 가능)
                r=1;
            } 
        }
        if(r==0){
            return 0;
        }
        
        
        Queue<wordset> q = new LinkedList<>();
        q.offer(new wordset(0,begin));
        while(!q.isEmpty()){
            wordset currentwordset = q.poll();
            if(currentwordset.word.equals(target)){
                answer=currentwordset.trial;
                break;
            }
            for(int i=0; i<words.length; i++){
                if(check[i]==0 && wordCompare(currentwordset.word,words[i])==true){
                    check[i]=1;
                    q.offer(new wordset(currentwordset.trial+1,words[i]));
                }
            }
        }
        return answer;
    }
}
