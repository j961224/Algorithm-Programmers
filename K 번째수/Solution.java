package prosortK¹øÂ°¼ö;
import java.util.*;

public class Solution {
	
	    public int[] solution(int[] array, int[][] commands){
	        int[] answer = new int [commands.length];
	        for(int i=0; i<commands.length; i++){
	            int[] chars = new int[commands[i][1]-commands[i][0]+1];
	            int k=0;
	            for (int j = commands[i][0]-1; j < commands[i][1]; j++) {
	                chars[k] = array[j];
	                k=k+1;
	            }
	            Arrays.sort(chars);
	            answer[i]=chars[commands[i][2]-1];
	            
	        }
	        return answer;
	    
	}
}
