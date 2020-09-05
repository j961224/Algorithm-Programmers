package prohash����Ʈ�ٹ�;
import java.util.*;
//ù ��° �õ� : HashMap�� ������ list�� list<entry>�� ����Ϸ� ������ ����

//�� ��° �õ� : class ���� ��, �ű⿡ compareTo ������ �Ͽ� HashMap �̿��Ͽ� ArrayList�� ���� ���ϵ� id ���� ��� ����

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
        public int compareTo(Song o){//�帣 ���� ���� ���� ���ϴ� compareTo ������
            if(this.play == o.play){
                return this.id - o.id; // id�� ��������
            }
            else{
                return o.play-this.play; // play ���� ��������
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
                if(s1.genre.equals(s2.genre)){ // �帣 ���� ���, implement�� compareTo ������ �� ���� �θ���
                    return s1.compareTo(s2);
                }
                else{
                    return a.get(s2.genre)-a.get(s1.genre); // �帣�� �ٸ� ���, �� �帣�� play ���� Ƚ���� ū �� ������ ��������
                }
            }
        });
        
        ArrayList<Integer> rank = new ArrayList<>(); // �� �帣 2���� �� �ֱ�
        HashMap<String, Integer> b = new HashMap<>(); // �帣���� ���� 2���� �ڸ��� ���� hashmap
        
        for(Song q : so){
            if(!b.containsKey(q.genre)){
                b.put(q.genre,1);
                rank.add(q.id);
            }
            else{
                if(b.get(q.genre)>1){ // �� �帣�� 2�� �־��� ��� �׳� �Ѿ��
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
