import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		
		Stack<Integer> stack = new Stack<>();
		int sum,x,k;
		for(char c: arr) {
			switch(c) {
			case '(':
				stack.add(-1);
				break;
			case ')':
				sum = 0;
				while(stack.peek()!=-1) {
					sum+=stack.pop();
				}
				stack.pop();
				stack.add(sum);
				break;
			case 'C':
				stack.add(12);
				break;
			case 'H':
				stack.add(1);
				break;
			case 'O':
				stack.add(16);
				break;
			default:
				k = c-'0';
				x = stack.pop();
				stack.add(x*k);
				break;
			}
		}
		
		int answer = 0;
		while(!stack.isEmpty()) {
			answer+=stack.pop();
		}
		System.out.println(answer);
    }
}