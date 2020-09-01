package proheap디스크컨트롤러;

import java.util.*;
//처음에 Arrays.sort로 작업이 요청되는 시점을 기준으로 jobs를 오름차순 정렬
//다음으로 while(true)문 안에 while문으로 작업 요청되는 시점이 비슷한 시간들끼리에서 작업 소요시간이 짧은 경우로 오름차순한다.
//그리고 계산하여 job의 원소를 다 돌고 queue가 비어있다면 나와서 걸린 시간을 합한 sum을 이용하여 return한다. 

public class Solution {
    
    class Time implements Comparable<Time>{
        int startTime;
        int endTime;
        
        Time(int startTime, int endTime){
            this.startTime=startTime;
            this.endTime=endTime;
        }
        
        @Override
        public int compareTo(Time t){
            return this.endTime-t.endTime;
        }//걸리는 시간이 짧은 경우 찾기 (음수일 경우 짧을수록 정렬이니 오름차순)
    }
    
    public int solution(int[][] jobs) {
        Queue<Time> qu = new PriorityQueue<>();
        int sum=0;
        int answer=0;
        int index=0;
        int stime=0;
        
        Arrays.sort(jobs,new Comparator<int []>(){
            
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]-o2[0];//오름차순(음수일경우 o1,o2순으로 정렬)
                //return o2.compareTo(o1);
            }
        }); //시작 시간이 짧은 순으로 정렬
        
        while(true){
            while(index<jobs.length && jobs[index][0]<=stime){
                qu.add(new Time(jobs[index][0], jobs[index][1]));
                index++;
            }//원래 (1,9), (2,6) 일 때보다 (2,6), (1,9)로 필요로 할 때 실시간 sort를 위해 우선 순위 queue 사용할 아이디어 제시!
            
            if(!qu.isEmpty()){
                Time tt=qu.poll();
                stime += tt.endTime;
                sum += stime - tt.startTime;
            }
            
            else{
                stime = jobs[index][0];//다음 배열에 시작되는 시간 맞추기
                
            }
            
            if(index == jobs.length && qu.isEmpty()) break;
            
        }
        
        answer = sum/jobs.length;
            
        return answer;
    }
}
