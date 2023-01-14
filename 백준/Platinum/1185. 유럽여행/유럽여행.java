import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] root;
	static int cost;
	static class Edge implements Comparable<Edge>{
		int s,e,c;

		public Edge(int s, int e, int c) {
			super();
			this.s = s;
			this.e = e;
			this.c = c;
		}

		@Override
		public int compareTo(Edge o) {
			return this.c-o.c;
		}
		
	}
	static int find(int x) {
		if(root[x]!=x)
			root[x] = find(root[x]);
		return root[x];
	}
	
	static void union(Edge edge) {
		int a = find(edge.s);
		int b = find(edge.e);
		if(a==b)
			return;
		if(a<b)
			root[b] = a;
		else if(b<a)
			root[a] = b;
		cost+=edge.c;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		root = new int[n+1];
		int[] stay = new int[n+1];
		int min = 1001;
		for(int i = 1;i<=n;i++) {
			root[i] = i;
			stay[i] = Integer.parseInt(br.readLine());
			min = Math.min(stay[i], min);
		}
		Edge[] edges = new Edge[m];
		int s,e,c;
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(s,e,stay[s]+stay[e]+2*c);
		}
		
		Arrays.sort(edges);
		
		cost = min;
		for(Edge edge:edges) {
			union(edge);
		}
		
		System.out.println(cost);
	}
}