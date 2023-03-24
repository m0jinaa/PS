import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int n, k;
	public static int[] depth;
	public static int[][] parent;
	public static ArrayList<Integer>[] graph;
	
	public static void dfs(int x,int d) {
		depth[x] = d;
		
		for(int i:graph[x]) {
			if(depth[i]!=0)
				continue;
			parent[i][0] = x;
			dfs(i,d+1);
		}
	}
	
	public static void setParents() {
		for(int i = 0;i<k;i++) {
			for(int j = 1;j<=n;j++) {
				if(parent[j][i]!=0 && parent[parent[j][i]][i]!=0) {
					parent[j][i+1] = parent[parent[j][i]][i];
				}
			}
		}
	}
	
	public static int lca(int a, int b) {
		if(depth[a]>depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		for(int i = k-1;i>=0;i--) {
			if((int)Math.pow(2, i)<=depth[b]-depth[a]) {
				b = parent[b][i];
			}
		}
		
		if(a==b) {
			return a;
		}
		
		for(int i = k-1;i>=0;i--) {
			if(parent[a][i]!=parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		
		return parent[a][0];
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		k = (int)Math.ceil(Math.log10(n)/Math.log10(2));
		
		graph = new ArrayList[n+1];
		depth = new int[n+1];
		parent = new int[n+1][k];
		
		for(int i = 1;i<=n;i++) {
			graph[i] = new ArrayList<Integer>();
		}
		int a,b;
		for(int i = 1;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		dfs(1,1);
		
		setParents();
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			sb.append(lca(a,b)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
