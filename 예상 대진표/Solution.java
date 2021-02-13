class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        
        int left=0;
        int right=0;
        if(a > b){
            left = b;
            right = a;
        } 
        else {
            left = a;
            right = b;
        }
            
        while(true){
            int tmp=0;
            int last=0;
            if(right-left==1 && left%2!=0){
                break;
            }
            tmp=right/2;
            last=right%2;
            right=tmp+last;
            
            tmp=left/2;
            last=left%2;
            left=tmp+last;
            
            answer++;
        }

        return answer;
    }
}