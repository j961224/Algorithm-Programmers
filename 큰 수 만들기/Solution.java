package progreedyū�������;
import java.util.*;
//ó���� �� �ϳ��� split�� �߶� �ϳ��� ������ ������ �ٽ� �����Ͽ� �ݴ�� �� �� �ִ� ���¿��� �ϳ��� ����� �����ߴ�.

public class Solution {
	public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        int delnum=0;
        int i = 1;
        
        while(delnum != k){
            if(i>=1 && sb.charAt(i-1)<sb.charAt(i)){//õõ�� ���� ���� ���� ������ ������ ���� ���� ����
                sb.deleteCharAt(i-1);
                i--;
                delnum++;
            }
            else{
                if(i==sb.length()-1 && sb.charAt(i)<=sb.charAt(i-1)){
                    sb.deleteCharAt(i);
                    i--;
                    delnum++;
                }
                else{
                    i++;
                }
            }
        }
        return sb.toString();
    }
}
