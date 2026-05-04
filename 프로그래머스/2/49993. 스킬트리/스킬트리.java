class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        final int MAX = 26;
        
        int[] order = new int[MAX];
        
        char[] skills = skill.toCharArray();
        
        int n = skills.length;
        
        for(int i = 0;i<n;i++){
            order[skills[i]-'A'] = i+1;    
        }
        
        int learned = 0;
        char[] tree;
        
        int m = skill_trees.length;
        boolean possible;
        
        for(int i = 0;i<m;i++){
            possible = true;
            learned = 0;
            
            tree = skill_trees[i].toCharArray();
        
            for(char t : tree){
                if(order[t-'A']==learned+1){
                    learned++;
                }
                else if(order[t-'A']>learned+1){
                    possible = false;
                    break;
                }
            }
            
            if(possible){
                answer++;
            }
        }
        return answer;
    }
}