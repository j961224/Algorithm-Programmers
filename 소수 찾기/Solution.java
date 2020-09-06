package profullsearch�Ҽ�ã��;
import java.util.*;

public class Solution {
	public static HashSet<Integer> number = new HashSet<>();
    public static boolean[] NUM = new boolean[10000000];
    public int solution(String numbers) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        Arrays.fill(NUM,true);
        NUM[0]=NUM[1]=false; // 0�� 1�� �Ҽ��̹Ƿ�
        
        String[] numberas = numbers.split("");
        boolean[] check = new boolean[numberas.length];
        makeNum(numberas, check, sb);
        
        for(int num : number){
            if(isPrime(num)){
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void makeNum(String[] numberas, boolean[] check, StringBuilder sb){
        boolean finish = true;
        for(boolean flag : check){
            if(!flag){
                finish=false;
                break;
            }
        }
        if(finish) return;
        
        for(int i=0; i<check.length; i++){
            if(!check[i]){
                sb.append(numberas[i]);
                number.add(Integer.parseInt(sb.toString()));
                check[i]=true;
                makeNum(numberas,check,sb);
                check[i]=false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    
    public static boolean isPrime(int num){
    	// �����佺�׳׽��� ü�� �̿�
        for(int i = 2; i <= Math.sqrt(num); i++){
            for(int j = 2; j * i <= num ; j++){
                NUM[j * i] = false;
            }
        }
        return NUM[num];
    }
}
