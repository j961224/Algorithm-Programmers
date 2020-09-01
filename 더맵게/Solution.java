package proheap더맵게;
import java.util.*;
//처음에 Arrays.sort로 scoville을 오름차순으로 정렬 후에 stack을 이용해서 사용할려고 함 => 그러나 실패(stack으로 하면 앞에 2개의 원소가 K보다 크지만 그 다음 원소가 K보다 작을 수 있기 때문이다.) -> 다음 아이디어로 우선순위 큐 생각(자동으로 큐 넣을때마다 오름차순을 해주고 코드상으로 많이 구현을 안 해도 되기 때문)

//Priority Queue로 오름차순으로 정렬한 뒤 비교 전 peek를 이용하여 가장 작은 값이 K보다 크다면 -1 출력
//다음 경우로 while문으로 queue를 계속 계산하면서 peek를 이용해서 한 번 계산하고 제일 작은 원소가 K보다 크거나 같을 경우 stop! => 계산 횟수를 answer로 계산

public class Solution {
	public int solution(int[] scoville, int K) {
        int answer=0;
        Queue<Integer> qu = new PriorityQueue<Integer>(scoville.length);
        for(int i=0; i<scoville.length; i++){
            qu.offer(scoville[i]);
        }
        if(qu.peek()>=K){
            return -1;
        }
        
        while(qu.peek()<K){
            if(qu.size()==1) return -1;
            int rec =0;
            int rec1 =0;
            int q=0;
            
            rec=qu.poll();
            rec1=qu.poll();
            q=rec+(2*rec1);
            qu.offer(q);
            answer++;
        }
        return answer;
//         int answer = -1;
//         int count=0;
//         Stack<Integer> sco = new Stack<Integer>();
        
//         Arrays.sort(scoville);
        
//         for(int i=scoville.length-1; i>=0; i--){
//             sco.push(scoville[i]);
//         }
//         int initi=0;
        
//         if(scoville[0]>=K){
//             initi=1;
//         }
        
//         if(initi==1){
//             //answer=-1;
//             return answer;
//         }
        
//         else{
//             while(sco.size()>1){
//                 int qe=0;
//                 int rec=0;
//                 int rec1=0;
//                 rec=sco.pop();
//                 rec1=sco.pop();
//                 if(rec>=K && rec1>=K){
//                     answer=count;
//                     break;
//                 }
//                 else{
//                     if(rec>=rec1){
//                         qe=rec1+(2*rec);
//                         sco.push(qe);
//                         count++;
//                     }
//                     else if(rec1>rec){
//                         qe=rec+(2*rec1);
//                         sco.push(qe);
//                         count++;
//                     }
//                 }
//             }
//         }
        
//         if(sco.size()==1){
//             int q=0;
//             q=sco.pop();
//             if(q>=K){
//                 answer=count;
//                 return answer;
//             }
//             else{
//                 answer=-1;
//                 return answer;
//             }
//         }
        
//         return answer;
    }
}
