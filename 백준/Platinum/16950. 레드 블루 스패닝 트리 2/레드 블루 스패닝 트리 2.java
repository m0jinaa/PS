import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int n,k;
	static int[] root2;
	static Edge[] edges;
	static StringBuilder sb = new StringBuilder();
	static class Edge{
		int s,e,c;

		public Edge(int s, int e, int c) {
			super();
			this.s = s;
			this.e = e;
			this.c = c;
		}
	}
	static int find(int[] r,int x) {
		if(r[x]!=x)
			r[x] = find(r,r[x]);
		return r[x];
	}
	
	static boolean union(int[] r,int a, int b) {
		a = find(r,a);
		b = find(r,b);
		if(a==b)
			return false;
		else if(a<b)
			r[b] = a;
		else
			r[a] = b;
		return true;
		
	}
	static void init(int[] r) {
		for(int i = 1;i<=n;i++)
			r[i] = i;
	}
	static int getBlueCnt(int[] r,int flag) {

		int cnt = 0;
		if(flag==0) {
			Arrays.sort(edges, new Comparator<Edge>() {

				@Override
				public int compare(Edge e1, Edge e2) {
					return e1.c-e2.c;
				}
			});
		}
		else {
			Arrays.sort(edges, new Comparator<Edge>() {
				
				@Override
				public int compare(Edge e1, Edge e2) {
					return e2.c-e1.c;
				}
			});	
		}
		init(r);
		
		for(Edge edge:edges) {
			if(union(r,edge.s,edge.e)) {
				cnt+=edge.c;
				if(flag==0 && edge.c==1) {
					union(root2,edge.s,edge.e);
					sb.append(edge.s).append(" ").append(edge.e).append("\n");
				}				
			}
		}
		
		return cnt;
	}
	
	static void useKBlue(int c) {
		int cnt = c;
		for(Edge edge:edges) {
			if(cnt==n-1)
				break;
			if(edge.c==1 && c==k)
				continue;
			if(union(root2,edge.s,edge.e)) {
				if(edge.c==1)
					c++;
				sb.append(edge.s).append(" ").append(edge.e).append("\n");
				cnt++;
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int m,f,t;
		String c;
		int min,max;
		
		st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int[] root = new int[n+1];
		root2 = new int[n+1];
		edges = new Edge[m];
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			c = st.nextToken();
			f = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(f,t,c.equals("B")?1:0);
		}
		init(root2);
		min = getBlueCnt(root,0);
		max = getBlueCnt(root,1);
		
		if(min<=k && k<=max) {
			useKBlue(min);
		}
		else {
			sb.setLength(0);
			sb.append("0\n");
		}
			
		System.out.println(sb.toString());	
	}
}