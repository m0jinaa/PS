import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] root, enemy;
	
	static int find(int x) {
		if(root[x]!=x)
			root[x] = find(root[x]);
		
		return root[x];
	}
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x==y)
			return false;
		else if(x<y)
			root[y] = x;
		else
			root[x] = y;
		return false;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		root = new int[n+1];
		
		enemy = new int[n+1];
		
		for(int i = 1;i<=n;i++) {
			root[i] = i;
		}
		int a,b;
		int ans=1;
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			a = find(a);
			b = find(b);
			if(a==b) {
				ans = 0;
				break;
			}
			
			if(enemy[b]!=0)
				union(a,enemy[b]);
			else
				enemy[b] = a;

			if(enemy[a]!=0)
				union(b,enemy[a]);
			else
				enemy[a] = b;
			
		}
		
		System.out.println(ans);
	}
}