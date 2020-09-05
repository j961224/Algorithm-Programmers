package prohash베스트앨범;
import java.util.*;
//첫 번째 시도 : HashMap을 저장할 list인 list<entry>를 사용하려 했지만 실패

//두 번째 시도 : class 정의 후, 거기에 compareTo 재정의 하여 HashMap 이용하여 ArrayList에 먼저 수록될 id 차례 대로 저장

public class Solution {
	class Song implements Comparable<Song>{
        int id, play;
        String genre;
        Song(int id, int play, String genre){
            this. id = id;
            this. play = play;
            this. genre = genre;
        }
        
        @Override
        public int compareTo(Song o){//장르 같을 때의 순위 정하는 compareTo 재정의
            if(this.play == o.play){
                return this.id - o.id; // id는 오름차순
            }
            else{
                return o.play-this.play; // play 수는 내림차순
            }
        }
    }
    
    
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> a = new HashMap<>();
        ArrayList<Song> so = new ArrayList<>();
        
        for(int i=0; i<genres.length; i++){
            
            so.add(new Song(i,plays[i],genres[i]));
            
            if(a.containsKey(genres[i])){
                a.replace(genres[i],a.get(genres[i])+plays[i]);
            }
            else{
                a.put(genres[i],plays[i]);
            }
        }
        
        Collections.sort(so,new Comparator<Song>(){
            @Override
            public int compare(Song s1, Song s2){
                if(s1.genre.equals(s2.genre)){ // 장르 같을 경우, implement로 compareTo 재정의 한 것을 부르기
                    return s1.compareTo(s2);
                }
                else{
                    return a.get(s2.genre)-a.get(s1.genre); // 장르가 다를 경우, 그 장르의 play 누적 횟수가 큰 게 먼저니 내림차순
                }
            }
        });
        
        ArrayList<Integer> rank = new ArrayList<>(); // 각 장르 2개씩 곡 넣기
        HashMap<String, Integer> b = new HashMap<>(); // 장르마다 상위 2개를 자르기 위한 hashmap
        
        for(Song q : so){
            if(!b.containsKey(q.genre)){
                b.put(q.genre,1);
                rank.add(q.id);
            }
            else{
                if(b.get(q.genre)>1){ // 한 장르에 2개 넣었을 경우 그냥 넘어가기
                    continue;
                }
                else{
                    b.replace(q.genre,2);
                    rank.add(q.id);
                }
            }
        }
        
        int[] answer = new int[rank.size()];
        for(int i=0; i<rank.size(); i++){
            answer[i]=rank.get(i);
        }
        return answer;
                         
                         
    }
}
