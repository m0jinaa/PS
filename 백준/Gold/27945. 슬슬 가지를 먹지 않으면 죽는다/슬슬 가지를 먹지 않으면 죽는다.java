import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static class Edge implements Comparable<Edge>{
		int a, b, c;

		public Edge(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Edge e) {
			return this.c-e.c;
		}	
	}
	
	static int find(int a) {
		if(a!=parent[a]) {
			parent[a] = find(parent[a]);
		}
		return parent[a];
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b)
			return false;
		else if(a<b) {
			parent[b] = a;
		}
		else {
			parent[a] = b;
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		
		for(int i = 1;i<=n;i++) {
			parent[i] = i;
		}
		int a,b,c;
		
		Edge[] edges = new Edge[m];
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(a,b,c);
			
		}
		
		Arrays.sort(edges);
		int answer = 0;
		for(Edge edge:edges) {
			if(union(edge.a,edge.b) && answer+1 == edge.c) {
				answer = edge.c;
			}
			else {
				break;
			}
		}
		
		System.out.println(answer+1);
	}
}