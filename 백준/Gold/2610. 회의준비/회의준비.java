import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int[] root;
	static int[][] dist;
	static int INF = 999999;
	public static int find(int x) {
		if(x!=root[x])
			root[x] = find(root[x]);
		return root[x];
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y)
			return;
		else if(x<y)
			root[y] = x;
		else
			root[x] = y;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[] cost = new int[n+1];
		int[] boss = new int[n+1];
		
		root = new int[n+1];
		dist = new int[n+1][n+1];
		for(int i = 1;i<=n;i++) {
			for(int j = 1;j<=n;j++) {
				dist[i][j] = INF;
			}
			root[i] = i;
			cost[i] = INF;
			boss[i] = 0;
		}
		
		int a,b;
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			union(a,b);
			dist[a][b] = 1;
			dist[b][a] = 1;
		}
		
		
		for(int k = 1;k<=n;k++) {
			for(int i = 1;i<=n;i++) {
				for(int j = 1;j<=n;j++) {
					if(i==j || j==k || i==k)
						continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		}
		int c = 0;
		int x;
		for(int i = 1;i<=n;i++) {
			c = 0;
			for(int j = 1;j<=n;j++) {
				if(dist[i][j] == INF)
					continue;
				c = Math.max(c,dist[i][j]);
			}
			x = find(i);
			if(cost[x]>c) {
				cost[x] = c;
				boss[x] = i;
			}
		}
		
		ArrayList<Integer> bosses = new ArrayList<Integer>();
		
		for(int i:boss) {
			if(i!=0)
				bosses.add(i);
		}
		
		Collections.sort(bosses);
		
		StringBuilder sb = new StringBuilder();
		sb.append(bosses.size()).append("\n");
		for(int i:bosses)
			sb.append(i).append("\n");
		
		System.out.println(sb.toString());
	}
}
