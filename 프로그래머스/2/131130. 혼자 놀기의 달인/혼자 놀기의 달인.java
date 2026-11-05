class Solution {
    int[] group;
    boolean union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a == b){
            return false;
        }
        else if(a<b){
            group[b] = a;
        }
        else{
            group[a] = b;
        }
        
        return true;
    }
    
    int find(int a){
        if(a!=group[a]){
            group[a] = find(group[a]);
        }
        
        return group[a];
    }
    
    public int solution(int[] cards) {
        int n = cards.length;
        
        group = new int[n];
        
        for(int i = 1;i<n;i++){
            group[i] = i;
        }
        
        int first = 0;
        int second = 0;
        
        int c = 0;
        
        int nx;
        
        for(int i = 0;i<n;i++){
            if(group[i] != i){
                continue;
            }
            
            nx = cards[i]-1;
            c = 1;
            
            while(union(i,nx)){
                c++;
                nx = cards[nx]-1;
            }
            
            if(first<c){
                second = first;
                first = c;
            }
            else if(second<c){
                second = c;
            }
        }
        
        return first*second;
    }
}