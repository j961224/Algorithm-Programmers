package prostack�ֽİ���;
import java.util.*;
//1��° ���̵��: ���� �ε��� 0�� ���ڸ� �� �ε��� 0 �ڿ� ���ڿ� ���ؼ� ���ų� ū ������ return => �׷��� �ϴϱ� 1�� ����

//2��° ���̵��: �ε��� i�� ���� i���� ū �ε��� j�� ���� ���ؼ� �ε��� i�� ���� Ŭ ��, j-i�� return

//and �ε��� i�� ������ ū ���� ���� ���, �ε��� j=length-1���� ���µ� ���⼭ j-i�� �� ���� return
public class Solution {
	public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length; i++){
            
            for(int j=i+1; j<prices.length; j++){
                if(prices[i]>prices[j]){//�ε��� i�� ���� i���� ū �ε��� j�� ���� ���ؼ� �ε��� i�� ���� Ŭ ��, j-i�� return
                    answer[i]=j-i;
                    break;
                }
                if(j==prices.length-1){// and �ε��� i�� ������ ū ���� ���� ���, �ε��� j=length-1���� ���µ� ���⼭ j-i�� �� ���� return
                    answer[i]=j-i;
                }
            }
            //answer[i]=k;
        }
        
        return answer;
    }
}
