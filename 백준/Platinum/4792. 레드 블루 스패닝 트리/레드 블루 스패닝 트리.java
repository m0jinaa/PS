import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[] root;
	static int n;
	static Edge[] edges;
	static class Edge{
		int s,e,c;

		public Edge(int s, int e, int c) {
			super();
			this.s = s;
			this.e = e;
			this.c = c;
		}
	}
	static int find(int x) {
		if(root[x]!=x)
			root[x] = find(root[x]);
		return root[x];
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b)
			return false;
		else if(a<b)
			root[b] = a;
		else
			root[a] = b;
		return true;
		
	}
	static void init() {
		for(int i = 1;i<=n;i++)
			root[i] = i;
	}
	static int getBlueCnt(int flag) {
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
		
		init();
		
		for(Edge edge:edges) {
			if(union(edge.s,edge.e))
				cnt+=edge.c;
		}
		
		return cnt;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int m,k,f,t;
		String c;
		int min,max;
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			if(n==0 && m==0 && k==0)
				break;
			root = new int[n+1];
			edges = new Edge[m];
			
			for(int i = 0;i<m;i++) {
				st = new StringTokenizer(br.readLine()," ");
				c = st.nextToken();
				f = Integer.parseInt(st.nextToken());
				t = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(f,t,c.equals("B")?1:0);
			}
			
			min = getBlueCnt(0);
			max = getBlueCnt(1);
			
			if(min<=k && k<=max) {
				sb.append("1\n");
			}
			else {
				sb.append("0\n");
			}
			
		}
		System.out.println(sb.toString());
		
	}
}