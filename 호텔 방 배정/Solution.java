import java.util.*;
//효율성 문제에 hashmap쓰는 문제가 꽤 나오는 듯 하다 -> HashMap 명령어 외우기!
class Solution {
    HashMap<Long, Long> hm;
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        hm = new HashMap<>();
        for(int i=0; i<room_number.length; i++){
            answer[i]=findroom(room_number[i]);
        }
        return answer;
    }
    
    public long findroom(long room){
        if(!hm.containsKey(room)){
            hm.put(room,room+1);
            return room;
        }
        
        long next = hm.get(room);
        long findempty = findroom(next);
        hm.put(room,findempty);
        return findempty;
    }
}