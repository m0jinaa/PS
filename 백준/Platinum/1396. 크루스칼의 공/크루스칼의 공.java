import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] root,size;
	static int n;
	static ArrayList<Integer>[] list;
	static class Query{
		int x,y,s,e;
		public Query(int x, int y, int s, int e) {
			super();
			this.x = x;
			this.y = y;
			this.s = s;
			this.e = e;
		}
	}
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
	
	static void initRoot() {
		for(int i = 1;i<=n;i++) {
			root[i] = i;
			size[i] = 1;
		}
	}
	
	static int find(int x) {
		if(root[x]!=x)
			root[x] = find(root[x]);
		return root[x];
	}
	
	static boolean union(int x,int y) {
		x = find(x);
		y = find(y);
		
		if(x==y)
			return false;
		else if(x<y) {
			root[y] = x;
			size[x] += size[y];
			
		}
		else {
			root[x] = y;
			size[y] += size[x];
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Edge[] edges = new Edge[m];
		size = new int[n+1];
		root = new int[n+1];
		
		int a,b,c;
		for(int i= 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(a,b,c);
		}
		
		Arrays.sort(edges);
		
		int Q = Integer.parseInt(br.readLine());
		Query[] query = new Query[Q];
		int x,y;
		int[][] ans = new int[Q][2];
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine()," ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			query[i] = new Query(x,y,0,m-1);
		}
		list = new ArrayList[m+1];
		for(int i = 0; i <= m; i++)
			list[i] = new ArrayList<Integer>();
		
		boolean done;
		Query q;
		while(true) {
			done = true;
			for(int i = 0; i <= m; i++)
				list[i].clear();
			
			for(int i = 0; i < Q; i++) {
				q = query[i];
				if(q.s>q.e)
					continue;
				done = false;
				
				list[(q.s+q.e)/2].add(i);
				
			}
			
			if(done)//모든 쿼리 처리 완료
				break;
			
			initRoot();
			int t = 0;
			for(Edge edge:edges) {
				union(edge.s,edge.e);
				
				for(int i:list[t]) {
					q = query[i];
					if(find(q.x)==find(q.y)) {
						ans[i][0] = edge.c;
						ans[i][1] = size[find(q.x)];
						q.e = t-1;
					}
					else
						q.s = t+1;
				}
				t++;
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for(int[] row:ans) {
			if(row[0] == 0)
				sb.append("-1\n");
			else
				sb.append(row[0]).append(" ").append(row[1]).append("\n");
		}
		System.out.println(sb.toString());
	}
}