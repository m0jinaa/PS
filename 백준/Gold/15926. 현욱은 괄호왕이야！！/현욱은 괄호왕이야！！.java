import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		char[] arr = br.readLine().toCharArray();
		
		Stack<Integer> stack = new Stack<>();
		
		int answer = 0;
		int x;
		for(char c : arr) {
			switch(c) {
			case '(':
				stack.add(-1);
				break;
			case ')':
				if(!stack.isEmpty() && stack.peek()==-1) {
					stack.pop();
					x = 2;
					while(!stack.isEmpty() && stack.peek()>0) {
						x+=stack.pop();
					}
					stack.add(x);
					answer = Math.max(answer, stack.peek());
				}
				else if(!stack.isEmpty() && stack.peek()> 0) {
					x = stack.pop();
					if(!stack.isEmpty() && stack.peek()==-1) {
						stack.pop();
						while(!stack.isEmpty() && stack.peek()>0) {
							x+=stack.pop();
						}
						stack.add(x+2);
						answer = Math.max(answer, stack.peek());
					}
					else {
						stack.add(-2);
					}
				}
				else {
					stack.add(-2);
				}
				break;
			}
		}
		
		System.out.println(answer);		
	}
}