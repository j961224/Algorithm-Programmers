package prostack������;
import java.util.*;
//7469�� ���� ������ ����
//�� �˰����� �ð��� ���� �ɸ���.

public class Solution {
	public int solution(int[] priorities, int location){
        //int answer = 0;
        int count=0;
        Queue<Integer> qu = new LinkedList <>();
        
        for(int i=0; i<priorities.length; i++){
            qu.add(priorities[i]);
        }
        
        while(!qu.isEmpty()){
            int cu=qu.poll();//���� queue �� �տ� ���ڸ� ����
            
            boolean check = true;
            for(int i:qu){//�� ��Ұ� queue�� ��ҵ麸�� ������ �Ǻ�
                if(cu<i){
                    check=false;
                }
            }
            
            if(check){//���� ū ���ڰ� �� �տ� ���� �� count��
                count++;
                if(location==0){//���� ū ��Ұ� �տ� ������ ������ �ڿ� ���ϴ� target location�� �� ������ �������� ��
                    return count;
                }
            }
            else{//���������� �ؾ��ϹǷ� ���� ū ���� ���� �� �߰����� �ʰ� �ƴ� ���� �� �ڿ� �־��Ѵ�. 
                qu.add(cu);
            }
            
            location--; //���ϴ� target location�� �ϳ��� ������ �������Ƿ�
            if(location<0){//���ϴ� target location�� �ڷ� ���� �Ǵ� ���
                location+=qu.size();
            }
        }
        
        //return answer;
    }
}
