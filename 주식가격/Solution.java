package prostack주식가격;
import java.util.*;
//1번째 아이디어: 만약 인덱스 0의 숫자를 그 인덱스 0 뒤에 숫자와 비교해서 같거나 큰 개수를 return => 그렇게 하니까 1개 맞음

//2번째 아이디어: 인덱스 i의 수가 i보다 큰 인덱스 j의 수와 비교해서 인덱스 i의 수가 클 때, j-i를 return

//and 인덱스 i의 수보다 큰 것이 없을 경우, 인덱스 j=length-1까지 갔는데 여기서 j-i를 한 것을 return
public class Solution {
	public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length; i++){
            
            for(int j=i+1; j<prices.length; j++){
                if(prices[i]>prices[j]){//인덱스 i의 수가 i보다 큰 인덱스 j의 수와 비교해서 인덱스 i의 수가 클 때, j-i를 return
                    answer[i]=j-i;
                    break;
                }
                if(j==prices.length-1){// and 인덱스 i의 수보다 큰 것이 없을 경우, 인덱스 j=length-1까지 갔는데 여기서 j-i를 한 것을 return
                    answer[i]=j-i;
                }
            }
            //answer[i]=k;
        }
        
        return answer;
    }
}
