package 예산;

import java.util.*;
//이진 탐색을 쓰는 경우
//배열되어 있는 값에 특정한 값을 찾기 위해서 이용한다. => 중간값과 계속적으로 비교
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
          
          int mid = (start+end)/2; // 예산 예측
          int Sum = 0;
          
          for(int i=0; i<budgets.length; i++){
              if(budgets[i]>mid){
                  Sum+=mid;
              }
              else{
                  Sum+=budgets[i];
              }
          }
          
          if(Sum>M){//더 크니 기준을 낮춘다.
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
