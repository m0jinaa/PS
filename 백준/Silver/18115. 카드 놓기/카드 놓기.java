import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()," ");
		
		Stack<Integer> stack = new Stack<>();
		
		while(st.hasMoreTokens()) {
			stack.add(Integer.parseInt(st.nextToken()));
		}
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		int x = 1,y;
		int o;
		while(!stack.isEmpty()) {
			o = stack.pop();
			switch(o) {
			case 1:
				list.addFirst(x);
				break;
			case 2:
				y = list.pollFirst();
				list.addFirst(x);
				list.addFirst(y);
				break;
			case 3:
				list.addLast(x);
				break;
			}
			x++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i:list) {
			sb.append(i).append(" ");
		}
		System.out.println(sb.toString());
	}
}