package proDFSBFS�ܾȯ;
//1. ù��° bfs�� �ϴµ� Ƚ���� �ܾ ���� �ڵ带 ­�µ� �Ʒ��� ���� ������ �����Ѱ� ���̾���.
//==> ó���� bfs�� node��� int�� ���� �� �ϰ� �ؼ� �׷���...

//hit���� ������ hot�� ������ hot���� �� �� �Ⱦ dot, lot�� �����µ� Ƚ���� ���� 2�� �����ϰ� queue�� ������ check�ߴ����� ���� queue�� dot ���� lot�� �ڿ������� �ѱ�� ���� ����� ���� Ƚ�� �ϳ��� �ø� => Ƚ���� �ܾ�� ���� �����ϴ� ���� �߿�! => ������ queue ���������� Ƚ�� �ϳ��� �ø��� �ּ� �ܰ��� ������ �� ���� 
//�̷��� queue�� �ؼ� lot�� �־ Ƚ���δ� �� ġ���� �־ ���ؼ� dog ������ log�� �� �������� �ؾ��Ѵ�. => �׷��Ƿ� queue(Ƚ��, �׿� �ش��ϴ� �ܾ�)�� �����Ѵ�.

//Ƚ���� word ��� ����
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
    
    //���� �ϳ��� �ٸ��� Ȯ��
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
        
        //List<String> word = Arrays.asList(words);//word string �� �迭�� �� word�� list�� ����
        int[] check = new int[words.length];
        
        for(int i=0; i<words.length; i++){
            check[i]=0;
        }
        int r=0;
        for(int i=0; i<words.length; i++){ //���ʿ� words �迭�� ���� �ܾ ������ ��
            if(words[i].contains(target)){ //contains���� ���ڿ� ���� Ȯ��(string�� list.contains(string)�� ����)
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
