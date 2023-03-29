import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n,k;
	static Node[][] parent;
	static int[] store;
	static int[] depth;
	static ArrayList<Node>[] graph;
	
	static class Node{
		int x;
		boolean[] candy;
		public Node(int x,int a, int b) {
			super();
			candy = new boolean[6];
			this.x = x;
			candy[a] = true;
			candy[b] = true;
		}
		public Node(int x, boolean[] candy) {
			super();
			this.x = x;
			this.candy = candy;
		}
		
		public Node(int x, boolean a, boolean b, boolean c, boolean d, boolean e) {
			super();
			this.x = x;
			candy = new boolean[6];
			candy[1] = a;
			candy[2] = b;
			candy[3] = c;
			candy[4] = d;
			candy[5] = e;
		}
		
	}
	
	static void dfs(int x, int d) {
		depth[x] = d;
		
		for(Node node: graph[x]) {
			if(depth[node.x]!=0)
				continue;
			
			parent[node.x][0] = new Node(x,node.candy);
			
			dfs(node.x,d+1);
		}
	}
	
	static void setParent() {
		boolean a,b,c,d,e;
		for(int i = 0;i<k;i++) {
			for(int j = 1;j<=n;j++) {
				if(parent[j][i]!=null && parent[parent[j][i].x][i]!=null) {
					a = parent[j][i].candy[1] | parent[parent[j][i].x][i].candy[1];
					b = parent[j][i].candy[2] | parent[parent[j][i].x][i].candy[2];
					c = parent[j][i].candy[3] | parent[parent[j][i].x][i].candy[3];
					d = parent[j][i].candy[4] | parent[parent[j][i].x][i].candy[4];
					e = parent[j][i].candy[5] | parent[parent[j][i].x][i].candy[5];
					
					parent[j][i+1] = new Node(parent[parent[j][i].x][i].x,a,b,c,d,e);
				}
			}
		}
	}
	
	
	static boolean lca(int a, int b, int c) {
		if(depth[a]>depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		int v;
		boolean possible = store[a]==c | store[b]==c;
		for(int i = k-1;i>=0;i--) {
			v = (int)Math.pow(2, i);
			if(v<=depth[b]-depth[a]) {
				possible = possible | parent[b][i].candy[c];
				b = parent[b][i].x;
			}
		}
		
		if(a==b) {
			return possible;
		}
		
		for(int i = k-1;i>=0;i--) {
			
			if(parent[a][i]!=null && parent[a][i].x!=parent[b][i].x) {
				possible = possible | parent[a][i].candy[c] | parent[b][i].candy[c];
				a = parent[a][i].x;
				b = parent[b][i].x;
			}
		}
		
		possible = possible | parent[a][0].candy[c] | parent[b][0].candy[c];
		
		return possible;
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		k = (int)Math.ceil(Math.log10(n)/Math.log10(2));
		
		store = new int[n+1];
		boolean[] candy = new boolean[6];
		parent = new Node[n+1][k];
		depth = new int[n+1];
		graph = new ArrayList[n+1];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 1;i<=n;i++) {
			graph[i] = new ArrayList<Node>();
			store[i] = Integer.parseInt(st.nextToken());
			candy[store[i]] = true;
		}
		
		int u,v;
		
		for(int i = 1;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v,store[u],store[v]));
			graph[v].add(new Node(u,store[u],store[v]));
		}
		
		dfs(1,1);
		
		setParent();
		
		int m = Integer.parseInt(br.readLine());
		
		int now,x,y;
		
		st = new StringTokenizer(br.readLine()," ");
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		if(candy[y]) {
			sb.append("PLAY\n");
		}
		else {
			sb.append("CRY\n");
		}
		
		now = x;
		m--;
		while(m-->0) {
			st = new StringTokenizer(br.readLine()," ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			if(lca(now,x,y))  {
				sb.append("PLAY\n");
			}
			else {
				sb.append("CRY\n");
			}
			
			now = x;
			
		}
		
		System.out.println(sb.toString());

	}
}
