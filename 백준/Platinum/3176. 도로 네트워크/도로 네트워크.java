import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n,k;
	static Road[][] parent;
	static int[] depth;
	static ArrayList<Road>[] graph;
	
	static class Road{
		int x, min,max;

		public Road(int x, int min, int max) {
			super();
			this.x = x;
			this.min = min;
			this.max = max;
		}
	}
	
	static void dfs(int x, int d) {
		depth[x] = d;
		for(Road road:graph[x]) {
			if(depth[road.x]!=0)
				continue;
			
			parent[road.x][0] = new Road(x,road.min,road.max);
			dfs(road.x,d+1);
		}
	}
	
	static void setParent() {
		int min = 1000001,max = 0;
		for(int i = 0;i<k;i++) {
			for(int j = 1;j<=n;j++) {
				if(parent[j][i]!=null && parent[parent[j][i].x][i]!=null) {
					min = Math.min(parent[j][i].min, parent[parent[j][i].x][i].min);
					max = Math.max(parent[j][i].max, parent[parent[j][i].x][i].max);
					parent[j][i+1] = new Road(parent[parent[j][i].x][i].x,min,max);
				}
			}
		}
	}
	
	static String lca(int a, int b) {
		if(depth[a]>depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		int min = 1000001;
		int max = 0;
		int v;
		for(int i = k-1;i>=0;i--) {
			v = (int)Math.pow(2, i);
			
			if(v<=depth[b]-depth[a]) {
				min = Math.min(min, parent[b][i].min);
				max = Math.max(max, parent[b][i].max);
				b = parent[b][i].x;
			}
		}
		
		if(a==b)
			return min+" "+max;
		
		for(int i = k-1;i>=0;i--) {
			if(parent[a][i]!=null && parent[b][i]!=null && parent[a][i].x!=parent[b][i].x) {
				min = Math.min(min, Math.min(parent[a][i].min, parent[b][i].min));
				max = Math.max(max, Math.max(parent[a][i].max, parent[b][i].max));
				a = parent[a][i].x;
				b = parent[b][i].x;
			}
			
		}
		
		min = Math.min(min, Math.min(parent[a][0].min, parent[b][0].min));
		max = Math.max(max, Math.max(parent[a][0].max, parent[b][0].max));
		
		return min+" "+max;		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		k = (int)Math.ceil(Math.log10(n)/Math.log10(2));
		
		parent = new Road[n+1][k];
		depth = new int[n+1];
		
		graph = new ArrayList[n+1];
		
		for(int i = 1;i<=n;i++) {
			graph[i] = new ArrayList<Road>();
		}
		
		int a,b,c;
		
		for(int i = 1;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Road(b,c,c));
			graph[b].add(new Road(a,c,c));
		}
		
		dfs(1,1);
		
		setParent();

		int m = Integer.parseInt(br.readLine());
		
		int d,e;
		
		while(m-->0) {
			st = new StringTokenizer(br.readLine(), " ");
			d = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			sb.append(lca(d,e)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}