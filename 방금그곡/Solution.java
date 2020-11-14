package d;

import java.util.*;

class Solution {
    class Song implements Comparable<Song>{
        int cnt;
        int songlen;
        Song(int cnt, int songlen){
            this.cnt=cnt;
            this.songlen=songlen;
        }
        
        @Override
        public int compareTo(Song o){
            if(this.songlen == o.songlen){
                return this.cnt-o.cnt;
            }
            else{
                return o.songlen-this.songlen;
            }
        }
    }
    
    
    public String solution(String m, String[] musicinfos) {
        String answer="";
        int len = musicinfos.length;
		m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("A#", "a").replace("G#","g");        
        String[][] str = new String[len][6];
        String[] tmp = new String[len];
        for(int i=0; i<len; i++){
            String[] part = musicinfos[i].split(",");
            String[] part1 = part[0].split(":");
            String[] part2 = part[1].split(":");
            str[i][0]=part1[0];
            str[i][1]=part1[1];
            str[i][2]=part2[0];
            str[i][3]=part2[1];
            str[i][4]=part[2];
            tmp[i]=part[3].replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("A#", "a").replace("G#","g");
			
        }
        int[] solen = new int[len];
        for(int i=0; i<len; i++){
            int diffhour=Integer.parseInt(str[i][2])-Integer.parseInt(str[i][0]);
            int diffmin=Integer.parseInt(str[i][3])-Integer.parseInt(str[i][1]);
            
            int difftime=diffhour*60+diffmin;
            solen[i]=difftime;
            if(tmp[i].length()>=difftime){
                str[i][5]=tmp[i].substring(0,difftime);
            }
            else{
                StringBuilder sb = new StringBuilder();
                while(difftime>0){
                    sb.append(tmp[i]);
                    difftime-=tmp[i].length();
                }
                str[i][5]=sb.toString();
            }
        }
        
       
        LinkedList<Song> arr = new LinkedList<>();
        for(int i=0; i<len; i++){
            if(str[i][5].contains(m)){
                arr.add(new Song(i,solen[i]));
            }
        }
        
        if(arr.size()==0){
            answer="(None)";
        }
        else{
            Collections.sort(arr,new Comparator<Song>(){
                @Override
                public int compare(Song s1, Song s2){
                    return s1.compareTo(s2);
                }
            });
            
            answer=str[arr.get(0).cnt][4];
        }
        
        
        return answer;
    }
}