import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 0;
		
		int n = Integer.parseInt(br.readLine());
		char[] word;
		Stack<Character> stack = new Stack<>();
		
		while(n-->0) {
			stack.clear();
			
			word = br.readLine().toCharArray();
			
			for(char w:word) {
				if(!stack.isEmpty() && stack.peek()==w) {
					stack.pop();
				}
				else {
					stack.add(w);
				}
			}
			
			cnt += (stack.size()==0)?1:0;
		}
		
		System.out.println(cnt);
	}
}