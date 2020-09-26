package n진수게임;
//처음에 2진수, 8진수, 16진수만 생각해서 57.7점 나왔는데 모든 n진법을 다루어야겠다고 생각.

public class Solution {
	public String solution(int n, int t, int m, int p) {
        char[] tmp = new char[t];
        // String answer = "";
        StringBuilder sb = new StringBuilder();

        // if(n==2){
        //     int i=0;
        //     while(true){
        //         String binaryString = Integer.toBinaryString(i);
        //         sb.append(binaryString);
        //         if(sb.length() >= t*m){
        //             break;
        //         }
        //         i++;
        //     }
        // }
        // else if(n==8){
        //    int i=0;
        //     while(true){
        //         String octalString = Integer.toOctalString(i);
        //         sb.append(octalString);
        //         if(sb.length() >= t*m){
        //             break;
        //         }
        //         i++;
        //     } 
        // }
        // else if(n==16){
        //     int i=0;
        //     while(true){
        //         String hexString = Integer.toHexString(i);
        //         sb.append(hexString);
        //         if(sb.length() >= t*m){
        //             break;
        //         }
        //         i++;
        //     }
        // }
        for(int num=0; num<=t*m; ++num) {

            // 해당 숫자를 n진수로 변경
            StringBuilder col = convertNum(num, n);
            sb.append(col);
            if(sb.length()>t*m) break;
            
        }
        
        
        int k=1;
        int seq = p-1;
        while(t>=k){
            if(k==1){
                tmp[k-1]=sb.charAt(seq);
            }
            else{
                seq=seq+m;
                tmp[k-1]=sb.charAt(seq);
            }
            k++;
        }

        String answer = new String(tmp);
        return answer.toUpperCase();
        
    }
    private static StringBuilder convertNum(int num, int n) {
        StringBuilder sb = new StringBuilder();
        if(num == 0) return sb.append(0);

        while (num != 0) {
            int mod = num % n;
            if(mod >= 10) {
                int idx = 'A' + (mod-10);
                sb.append((char) idx);
            }

            else sb.append(mod);
            num /= n;
        }

        // 진수화시켰기 때문에 거꾸로 출력
        return sb.reverse();
    }
}
