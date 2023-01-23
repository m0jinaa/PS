import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] root;
	
	static int find(int x) {
		if(root[x]!=x)
			root[x] = find(root[x]);
		return root[x];
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y)
			return;
		root[x] = y;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int ans = n;
		
		int x,y,nx;
		
		root = new int[n+1];
		
		for(int i = 1;i<=n;i++)
			root[i] = i;
		
		while(m-->0) {
			st = new StringTokenizer(br.readLine()," ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			while(find(x)!=find(y)) {
				nx = find(x)+1;
				union(x,y);
				x = nx;
				ans--;
			}
		}
		
		System.out.println(ans);	
	}
}