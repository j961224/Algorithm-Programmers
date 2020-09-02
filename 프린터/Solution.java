package prostack프린터;
import java.util.*;
//7469번 백준 문제와 유사
//이 알고리즘은 시간이 많이 걸린다.

public class Solution {
	public int solution(int[] priorities, int location){
        //int answer = 0;
        int count=0;
        Queue<Integer> qu = new LinkedList <>();
        
        for(int i=0; i<priorities.length; i++){
            qu.add(priorities[i]);
        }
        
        while(!qu.isEmpty()){
            int cu=qu.poll();//현재 queue 맨 앞에 숫자를 빼기
            
            boolean check = true;
            for(int i:qu){//뺀 요소가 queue의 요소들보다 작은지 판별
                if(cu<i){
                    check=false;
                }
            }
            
            if(check){//제일 큰 숫자가 맨 앞에 있을 때 count함
                count++;
                if(location==0){//제일 큰 요소가 앞에 나오고 없어진 뒤에 원하는 target location이 맨 앞으로 도달했을 때
                    return count;
                }
            }
            else{//내림차순을 해야하므로 가장 큰 것을 뺏을 때 추가하지 않고 아닌 것은 맨 뒤에 둬야한다. 
                qu.add(cu);
            }
            
            location--; //원하는 target location이 하나씩 앞으로 땡겨지므로
            if(location<0){//원하는 target location이 뒤로 가게 되는 경우
                location+=qu.size();
            }
        }
        
        //return answer;
    }
}
