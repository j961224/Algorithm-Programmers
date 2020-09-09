package prosort가장큰수;
import java.util.*;
//문제를 보고 딱 생각한 아이디어는 number int를 string으로 돌려서 string끼리 합쳐서 내림차순 적용(Arrays.sort)해야 된다고 생각(34분)
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
        } // 이 부분은 계속 다른 거는 다 맞는데 1개 틀려서 인터넷에 다른 사람꺼 참조하니 0000인 경우에 0으로 만들어 줄 필요가 있다고 함
        
        for(int i=0; i<array.length;i++){
            answer+=array[i];
        }
        return answer;
    }
    
    
    //comparable interface 구현 -> 그냥 solution으로 넣어도 될 듯
    static class DescCompare implements Comparator<String> {
		@Override//comparator 메소드의 이름, 매개변수, 리턴 값이 모두 같으니 override 사용
		public int compare(String arg0, String arg1) {
			//내림차순으로 해야 합치면 가장 큰 수가 된다.
			return (arg1+arg0).compareTo(arg0+arg1); //이 부분은 인터넷에 찾아봄(string 합쳐서 compareTo을 사용하는 키워드로)
		}
 
	}
}
