import java.util.*;

class Solution {
    class fileio implements Comparable<fileio>{
        String filename;
        int filenum;
        String head;
        String number;
        String tail;
        
        fileio(String filename, int filenum, String head, String number, String tail){
            this.filename=filename;
            this.filenum=filenum;
            this.head=head;
            this.number=number;
            this.tail=tail;
        }
        
        @Override
        public int compareTo(fileio o){
            if(this.head.toLowerCase().compareTo(o.head.toLowerCase())>0){
                return 1;
            }
            
            else if(this.head.toLowerCase().compareTo(o.head.toLowerCase())==0){
                if(Integer.parseInt(this.number)-Integer.parseInt(o.number)>0){
                    return 1;
                }
                
                else if(Integer.parseInt(this.number)-Integer.parseInt(o.number)==0){
                    return this.filenum-o.filenum;
                }
            }
            return -1;
        }
    }
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        ArrayList<fileio> ar = new ArrayList<>();
        for(int i=0; i<files.length; i++){
            String filena = files[i];
            String hea = "";
            String num = "";
            String tai = "";
            
            //StringBuilder sb = new StringBuilder();
            //String name = filena.toLowerCase();
            for(int k=0; k<filena.length(); k++){
                char word = filena.charAt(k);
                
                if((word-'a' >=0 && word-'a'<=26) || (word == '-' || word == '.' || word == ' ' )){
                    if(!num.equals("")) {
                        tai += filena.substring(k);
                        break;
                    }
                    
                    else{
                        hea += filena.charAt(k);
                    }
                }
                
                else if(word-'0'>=0 && word-'0'<=57){
                    num += filena.charAt(k);
                }
            }
            ar.add(new fileio(filena, i, hea, num, tai));
            
        }
        
        Collections.sort(ar);
        for(int i=0; i<answer.length; ++i) {
            answer[i] = ar.get(i).filename;
        }
        return answer;
    }
}