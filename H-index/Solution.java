package prosortHindex;
import java.util.*;
//������������ ���� ��, �迭���� i+1��°�� i ������ ��� => for ���� ���� �ð��� ���� �ɸ�
//-> ������������ ����(�� index�� ���� ���� ���� index �� �̻��� ��� check)

public class Solution {
	public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        for(int i=0; i<citations.length; i++){
            if(citations[i]>=citations.length-i){
                //answer=citations[i]; -> 2��
                answer=citations.length-i;
                break;
            }
        }
        return answer;
    }
}
