import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		int n;
		String x;
		LinkedList<String> list = new LinkedList<String>();
		
		while(t-->0) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			
			while(n-->0) {
				x = st.nextToken();
				
				if(list.size()==0) {
					list.offer(x);
				}
				else if(list.peekFirst().compareTo(x) >= 0) {
					list.addFirst(x);
				}
				else {
					list.addLast(x);
				}
			}
			while(!list.isEmpty()) {
				sb.append(list.pollFirst());
			}
			sb.append("\n");			
		}
		System.out.println(sb.toString());
	}
}