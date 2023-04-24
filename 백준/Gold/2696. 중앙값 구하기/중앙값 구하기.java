import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> right = new PriorityQueue<>();
		
		int n,x,m,c;
		while(t-->0) {
			left.clear();
			right.clear();
			
			c = 0;
			m = Integer.parseInt(br.readLine());
			
			sb.append((m+1)/2).append("\n");
			
			n = (m+9)/10;
			
			while(n-->0) {
				st = new StringTokenizer(br.readLine()," ");
				
				while(st.hasMoreTokens()) {
					x = Integer.parseInt(st.nextToken());
					m--;
					if(left.isEmpty() || x<left.peek()) {
						left.add(x);
						if(m%2!=0) {
							right.add(left.poll());
						}
					}
					else {
						right.add(x);
						if(m%2==0) {
							left.add(right.poll());
						}
					}
					
					if(m%2!=0)
						continue;
					sb.append(left.peek());
					c++;
					if(c%10==0) {
						sb.append("\n");
					}
					else {
						sb.append(" ");
					}
				}
			}
			sb.append("\n");
			
		}

		System.out.println(sb.toString());
	}
}