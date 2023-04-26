import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] depth = new int[n+1];
		int[] left,right;
		left = new int[n+1];
		right = new int[n+1];
		TreeSet<Integer> set = new TreeSet<>();
		
		Integer a=0,b=0;
		long c = 0;
		int x;
		while(n-->0) {
			x = Integer.parseInt(br.readLine());
			a = set.higher(x);
			b = set.lower(x);
			
			set.add(x);
			if(a!=null && b==null) {
				left[a] = x;
				depth[x] = depth[a]+1;
			}
			else if(a==null && b!=null) {
				right[b] = x;
				depth[x] = depth[b]+1;
			}
			else if(a!=null && b!=null) {
				if(left[a]==0) {
					left[a] = x;
					depth[x] = depth[a]+1;
				}
				else {
					right[b] = x;
					depth[x] = depth[b]+1;
				}
			}
			c+=depth[x];
			
			sb.append(c).append("\n");
		}
		System.out.println(sb.toString());
	}
}