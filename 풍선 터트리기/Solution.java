import java.util.*;

//1. 배열의 양 끝은 항상 가능하다.
//	(나머지 숫자 중 제일 작은 숫자와 끝 중 더 큰 숫자 터트리는 기회 사용하면 된다.)
//2. 끝을 제한 가운데 숫자 중 끝이 제한 끝보다 작다면 그 숫자도 마지막까지 남을 수 있다.
//	(원래 규칙으로 끝과 그 숫자 중 터트리면 그 숫자가 끝이 되는 결과가 나오기 때문)

class Solution {
    public int solution(int[] a) {
        HashSet<Integer> hs = new HashSet<>();
        int min = a[0];
        for(int i=1; i<a.length; i++){
            hs.add(min);
            min = Math.min(min,a[i]);
        }
        
        min = a[a.length-1];
        for(int i=a.length-2; i>=0; i--){
            hs.add(min);
            min = Math.min(min,a[i]);
        }
        
        return hs.size();
    }
}