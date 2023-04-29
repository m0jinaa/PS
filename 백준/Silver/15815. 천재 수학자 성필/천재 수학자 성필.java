import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        Stack<Integer> stack = new Stack<>();
        int x,y;
        for(char c : arr){
            switch(c){
                case '+':
                    y = stack.pop();
                    x = stack.pop();
                    stack.add(x+y);
                    break;
                case '*':
                    y = stack.pop();
                    x = stack.pop();
                    stack.add(x*y);
                    break;
                case '-':
                    y = stack.pop();
                    x = stack.pop();
                    stack.add(x-y);
                    break;
                case '/':
                    y = stack.pop();
                    x = stack.pop();
                    stack.add(x/y);
                    break;
                default:
                    x = c-'0';
                    stack.add(x);
                    break;
            }
        }
        
        System.out.println(stack.pop());
	}
}