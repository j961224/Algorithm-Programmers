package ����;

import java.util.*;
//���� Ž���� ���� ���
//�迭�Ǿ� �ִ� ���� Ư���� ���� ã�� ���ؼ� �̿��Ѵ�. => �߰����� ��������� ��
class Solution {
  public int solution(int[] budgets, int M) {
      int answer = 0;
      Arrays.sort(budgets);
      
      int start = 0;
      int end = budgets[budgets.length-1];
      
      while(true){
          if(start>end){
              break;
          }
          
          int mid = (start+end)/2; // ���� ����
          int Sum = 0;
          
          for(int i=0; i<budgets.length; i++){
              if(budgets[i]>mid){
                  Sum+=mid;
              }
              else{
                  Sum+=budgets[i];
              }
          }
          
          if(Sum>M){//�� ũ�� ������ �����.
              end = mid-1;
          }
          else{
              start = mid+1;
              answer=Math.max(answer,mid);
          }
      }
      
      return answer;
  }
}
