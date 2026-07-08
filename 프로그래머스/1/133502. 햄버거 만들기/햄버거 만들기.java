import java.util.*;

class Solution {
    class Ingredient{
        int x, nx;
        
        public Ingredient(int x, int nx){
            this.x = x;
            this.nx = nx;
        }
    }
    public int solution(int[] ingredient) {
        int answer = 0;
        
        LinkedList<Ingredient> stack = new LinkedList<>();
        
        Ingredient bef;
        
        for(int ing : ingredient){
            
            if(!stack.isEmpty() && stack.peekLast().nx == ing){
                if(ing == 1){
                    stack.pollLast();
                    stack.pollLast();
                    stack.pollLast();
                    answer++;
                }
                else if(ing == 3){
                    stack.add(new Ingredient(ing,1));
                }
                else{
                    stack.add(new Ingredient(ing,ing+1));
                }
            }
            else if(ing == 1){
                stack.add(new Ingredient(ing,ing+1));
            }
            else{
                stack.add(new Ingredient(ing,0));
            }
        }
        
        return answer;
    }
}