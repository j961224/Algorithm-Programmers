import java.util.*;

class Solution {
    static int answer;
    public int solution(int n) {
        answer = 0;
        int[] ar = new int[n];
        for(int i=0; i<n; i++){
            ar[i]=n+3;
        }
        if(n==1){
            answer=1;
            return answer;
        }
        
        for(int i=0; i<n; i++){
            dp(0,i,ar,1,n);
        }
        
        return answer;
    }
    
    //시작하는 열,말을 두려고 하는 행,퀸 위치 상황,퀸 갯수
    public static void dp(int start, int index, int[] ar, int count, int n){
        if(start==n-1){
            if(count==n){
                answer+=1;
            }
            return;
        }
        
        ar[start]=index;
        //시작열에서 모든 행에 퀸이 가능한지 체크하는 변수 i
        for(int i=0; i<n; i++){
            boolean check = true;
            //시작하는 열 전까지의 열에 퀸 상황을 보고 start 열에 되는지 체크!
            for(int j=0; j<=start; j++){
                //1. 이미 퀸이 있는 행에 있으면 안됨
                //2. index있는 자리에서 다음 열은 index의 양옆에 존재하지 못 한다.
                if(ar[j]==i || Math.abs(index-i)<2){
                    check=false;
                    break;
                }
                //퀸의 사정거리 중 대각선에 걸리는 경우
                // 두려고 하는 열과 비교하는 열과의 거리==현재 퀸이 존재하는 자리에서 둘려고 하는 행 자리와의 거리
                if(Math.abs(start+1-j)==Math.abs(ar[j]-i)){
                    check=false;
                    break;
                }
            }
            
            if(check){
                //들어갈 수 있는 자리를 찾았으므로 재귀함수 호출
                dp(start+1,i,ar,count+1,n);
                //다른 행을 위해서 초기화
                ar[start+1]=0;
            }
        }
    }
}