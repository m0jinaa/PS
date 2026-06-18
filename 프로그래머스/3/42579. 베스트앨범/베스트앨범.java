import java.util.*;

class Solution {
    class Song {
        int ind;
        String genre;
        int played;
        
        public Song(int ind, String genre, int played){
            this.ind = ind;
            this.genre = genre;
            this.played = played;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> countMap = new HashMap();

        int n = genres.length;

        LinkedList<Song> songs = new LinkedList<>();
        
        for(int i = 0;i<n;i++){
            countMap.put(genres[i],countMap.getOrDefault(genres[i],0)+plays[i]);
            songs.add(new Song(i,genres[i],plays[i]));
        }
        
        Collections.sort(songs,Comparator.comparing((Song s) -> -(countMap.get(s.genre))).thenComparing(s->-(s.played)).thenComparing(s->s.ind));
        
        LinkedList<Integer> answerList = new LinkedList<>();
        
        int c = 0;
        String genre = "";
        
        Song s;
        
        while(!songs.isEmpty()){
            s = songs.pollFirst();
            
            if(!genre.equals(s.genre)){
                genre = s.genre;
                c = 1;
                answerList.add(s.ind);
            }
            else if(c < 2){
                c++;
                answerList.add(s.ind);
            }
        }
        
        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}