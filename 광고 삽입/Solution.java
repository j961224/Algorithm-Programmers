import java.util.*;
//매우 큰 수가 있을 수 있으므로 long을 사용
class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int playtime = TTS(play_time);
        int advtime = TTS(adv_time);
        
        long[] longtime = new long[playtime+1];
        for(int i=0; i<logs.length; i++){
            String[] sp = logs[i].split("-");
            longtime[TTS(sp[0])]++;
            longtime[TTS(sp[1])]--;
        }
        for(int i=1; i<=playtime; i++){
            longtime[i]+=longtime[i-1];
        }
        for(int i=1; i<=playtime; i++){
            longtime[i]+=longtime[i-1];
        }
        
        long max = longtime[advtime-1];
        int mstart=0;
        for(int i=0; i+advtime<=playtime; i++){
            long term = longtime[advtime+i]-longtime[i];
            if(term>max){
                max=term;
                mstart=i+1;
            }
        }
        
        answer=String.format("%02d:%02d:%02d",mstart/(60*60),(mstart/60)%60,mstart%60);
        return answer;
    }
    
    public int TTS(String time){
        String[] k = time.split(":");
        return Integer.parseInt(k[0])*60*60+Integer.parseInt(k[1])*60+Integer.parseInt(k[2]);
    }
}