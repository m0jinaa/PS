import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		int x;
		int answer = 0;
		
		while(n-->0) {
			st = new StringTokenizer(br.readLine()," ");
			st.nextToken();
			x = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty() && stack.peek()>=x) {
				if(stack.pop()!=x)
					answer++;
			}
			if(x!=0) {
				stack.add(x);
			}
		}
		
		answer+=stack.size();
		
		System.out.println(answer);	
	}
}