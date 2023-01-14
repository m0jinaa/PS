import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int[] root;
	static long cost;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer>[] link;
	static class Edge implements Comparable<Edge>{
		int s,e;
		long c;

		public Edge(int s, int e, long c) {
			super();
			this.s = s;
			this.e = e;
			this.c = c;
		}

		@Override
		public int compareTo(Edge o) {
			if(o.c<this.c)
				return -1;
			else if(o.c==this.c)
				return 0;
			else
				return 1;
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
		link[edge.s].add(edge.e);
		link[edge.e].add(edge.s);
		cost+=edge.c;
	}
	
	static void getPath(int now,int prev) {
		for(int i:link[now]) {
			if(i==prev)
				continue;
			getPath(i,now);
		}
		if(prev!=-1) {
			sb.append(prev+1).append(" ").append(now+1).append("\n");
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());

		root = new int[n];
		int[] p = new int[n];
		int[] c = new int[n];
		link = new ArrayList[n];
		
		for(int i = 0;i<n;i++) {
			root[i] = i;
			link[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine()," ");
			p[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Edge>edges = new ArrayList<Edge>();
		
		for(int i = 0;i<n;i++) {
			for(int j = i+1;j<n;j++){
				edges.add(new Edge(i,j,(c[i]+c[j])/Math.abs(p[i]-p[j])));
			}
		}
		
		Collections.sort(edges);
		
		for(Edge edge:edges) {
			union(edge);
		}
		
		sb.append(cost).append("\n");
		
		getPath(0,-1);
		
		System.out.println(sb.toString());
	}
}