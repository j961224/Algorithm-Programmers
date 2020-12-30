import java.util.*;
class Solution {
    static ArrayList<Integer> ar = new ArrayList<>();
    public int solution(int[] nums) {
        int answer=0;
        boolean[] visited= new boolean[nums.length];
        comb(nums, visited, 0, nums.length, 3);
        int size=0;
        while(size<ar.size()){
            boolean isPrime=false;
            for (int i = 2; i < ar.get(size); i++) {
                // 1과 num 자신 외에 나누어지는 수가 있는지 검사할 조건문
                if (ar.get(size) % i == 0) {
                    isPrime=true;
                // 한 번이라도 이 조건문이 실행될 경우 num은 소수가 아니므로 반복문을 빠져나온다.
                    break;
                }
            }
            if(isPrime==false){
                answer++;
            }
            size+=1;
        }
        return answer;
    }
    
    static void comb(int[] arr, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            addiction(arr, visited, n);
            return;
        }
        
        if (depth == n) {
            return;
        }

        visited[depth] = true;
        comb(arr, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        comb(arr, visited, depth + 1, n, r);
    }
    
    static void addiction(int[] arr, boolean[] visited, int n) {
        int tmp=0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                tmp+=arr[i];
            }
        }
        ar.add(tmp);
    }
}