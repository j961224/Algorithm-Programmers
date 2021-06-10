import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int matching=0;
        int countzero=0;
        
        for(int i=0; i<lottos.length; i++){
            if(contains(win_nums,lottos[i])){
                matching++;
            }
            else if(lottos[i]==0){
                countzero++;
            }
        }
        
        int mat = matching+countzero;
        
        switch(mat){
            case 6:
                answer[0]=1;
                break;
            case 5:
                answer[0]=2;
                break;
            case 4:
                answer[0]=3;
                break;
            case 3:
                answer[0]=4;
                break;
            case 2:
                answer[0]=5;
                break;
            default:
                answer[0]=6;
                break;
        }
        
        switch(matching){
            case 6:
                answer[1]=1;
                break;
            case 5:
                answer[1]=2;
                break;
            case 4:
                answer[1]=3;
                break;
            case 3:
                answer[1]=4;
                break;
            case 2:
                answer[1]=5;
                break;
            default:
                answer[1]=6;
                break;
        }
        
        
        return answer;
    }
    public static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }
}