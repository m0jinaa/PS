import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] root;
	static int find(int x) {
		if(root[x]!=x)
			root[x] = find(root[x]);
		return root[x];
	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b)
			return;
		else if(a<b)
			root[b] = a;
		else
			root[a] = b;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1;t<=tc;t++) {
			sb.append("Scenario ").append(t).append(":\n");
			int n = Integer.parseInt(br.readLine());
			root = new int[n+1];
			for(int i = 0;i<=n;i++) {
				root[i] = i;
			}
			int k = Integer.parseInt(br.readLine());
			int a,b,u,v;
			for(int i = 0;i<k;i++) {
				st = new StringTokenizer(br.readLine()," ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			int m = Integer.parseInt(br.readLine());
			for(int i = 0;i<m;i++) {
				st = new StringTokenizer(br.readLine()," ");
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				if(find(u)!=find(v))
					sb.append(0).append("\n");
				else
					sb.append(1).append("\n");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
