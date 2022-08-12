import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Long> stack = new Stack<Long>();
		long answer = 0;
		long max = 0;
		for(int i = 0;i<n;i++) {
			long val = Long.parseLong(br.readLine());
			max = Math.max(val, max);
			if(stack.isEmpty()) {
				stack.push(val);
			}
			else if (val<stack.peek()){
				stack.pop();
				stack.push(val);
			}
			else if(val>stack.peek()) {
				answer+=val-stack.pop();
				stack.push(val);
			}
		}
		while(!stack.isEmpty()) {
			answer+=max-stack.pop();
		}
		System.out.println(answer);
	}
}