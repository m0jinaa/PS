import java.util.*;

class Solution {
    class File implements Comparable<File>{
        int ind;
        String head;
        int number;
        String original;
        
        public File(int ind, String head, int number, String original){
            this.ind = ind;
            this.head = head;
            this.number = number;
            this.original = original;
        }
        
        public int compareTo(File f){
            if(f.head.equals(this.head)){
                if(f.number == this.number){
                    return this.ind - f.ind;
                }
                else{
                    return this.number - f.number;
                }
            }
            else{
                return this.head.compareTo(f.head);
            }
        }
    }
    
    public String[] solution(String[] files) {
        String[] answer = {};
        
        int n = files.length;
        
        File[] list = new File[n];
        
        String head;
        int number;
        
        int m,h,x;
        
        char[] file;
        
        for(int i = 0;i<n;i++){
            file = files[i].toCharArray();
            
            m = files[i].length();
            
            h = 0;
            
            head = "";
            
            for(int j = 0;j<m;j++){
                if(file[j]<'0' || file[j]>'9'){
                    head+=file[j];
                    continue;
                }
                h = j;
                break;
            }
            
            number = 0;
            
            for(int j = h;j<m && j<h+5;j++){
                if('0'<=file[j] && file[j]<='9'){
                    number = number*10+(file[j]-'0');
                    continue;
                }
                break;
            }
            
            head = head.toLowerCase();
            
            list[i] = new File(i,head,number,files[i]);
        }
        
        Arrays.sort(list);
        
        answer = Arrays.stream(list).map(f->f.original).toArray(String[]::new);
        
        return answer;
    }
}