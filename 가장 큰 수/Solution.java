package prosort����ū��;
import java.util.*;
//������ ���� �� ������ ���̵��� number int�� string���� ������ string���� ���ļ� �������� ����(Arrays.sort)�ؾ� �ȴٰ� ����(34��)
public class Solution {
	public String solution(int[] numbers) {
        String answer="";
        String[] array = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            array[i]=Integer.toString(numbers[i]);
        }
        
        Arrays.sort(array,new DescCompare());
        
        if (array[0].equals("0")){
            return "0";
        } // �� �κ��� ��� �ٸ� �Ŵ� �� �´µ� 1�� Ʋ���� ���ͳݿ� �ٸ� ����� �����ϴ� 0000�� ��쿡 0���� ����� �� �ʿ䰡 �ִٰ� ��
        
        for(int i=0; i<array.length;i++){
            answer+=array[i];
        }
        return answer;
    }
    
    
    //comparable interface ���� -> �׳� solution���� �־ �� ��
    static class DescCompare implements Comparator<String> {
		@Override//comparator �޼ҵ��� �̸�, �Ű�����, ���� ���� ��� ������ override ���
		public int compare(String arg0, String arg1) {
			//������������ �ؾ� ��ġ�� ���� ū ���� �ȴ�.
			return (arg1+arg0).compareTo(arg0+arg1); //�� �κ��� ���ͳݿ� ã�ƺ�(string ���ļ� compareTo�� ����ϴ� Ű�����)
		}
 
	}
}
