//정확성 통과, 효율성 불통과
// class Solution {
//     public int[] solution(int n, long k) {
//         ArrayList<Integer> ar = new ArrayList<>();
//         for(int i=1; i<n+1; i++){
//             ar.add(i);
//         }
        
//         return per(0,0,n,k,new int[n],ar);       
//     }
    
//     private int[] per(long cnt, int index, int n, long k, int[] answer, ArrayList<Integer> ar){
//         if(index==n){
//             return answer;
//         }
        
//         int ans=0;
//         long an = factorial(n-(index+1));
//         Collections.sort(ar);
        
//         while(true){
//             ans = ar.remove(0);
//             if(cnt+an>=k){
//                 break;
//             }
//             cnt+=an;
//             ar.add(ans);
//         }
//         answer[index]=ans;
//         return per(cnt,index+1,n,k,answer,ar);
//     }
    
//     private long factorial(int z){
//         long a=1;
//         while(z>=1){
//             a*=z--;
//         }
//         return a;
//     }
// }
import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        ArrayList<Integer> ar = new ArrayList<>();
        int[] answer = new int[n];
        long fact=1;
        for(int i=1; i<=n; i++){
            fact*=i;
            ar.add(i);
        }
        k--;
        
        int index=0;
        while(n>0){
            fact/=n; //앞에 1인 경우 2개, 2인 경우 2개이므로 6/3=2 설정
            answer[index++]=ar.get((int)(k/fact)); //2로 몇 번째 정수를 뽑을지 정하기
            ar.remove((int)(k/fact));
            k%=fact;
            n--;
        }
        
        return answer;
    }
}