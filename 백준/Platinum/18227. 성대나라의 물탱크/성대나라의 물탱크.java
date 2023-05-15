import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static long[] tree;
	static int[] depth,start,end;
	static ArrayList<Integer>[] graph;
	static int t = -1;
	static void dfs(int x) {
		start[x] = ++t;
		for(int i:graph[x]) {
			if(depth[i]!=0)
				continue;
			depth[i] = depth[x]+1;
			dfs(i);
		}
		end[x] = t;
	}
	
	static void update(int l, int r, int ind, int k) {
		if(l<=ind && ind<=r) {
			tree[k]++;
			if(l!=r) {
				int m = (l+r)/2;
				update(l,m,ind,2*k);
				update(m+1,r,ind,2*k+1);
			}
		}
	}
	
	static long get(int l, int r, int s, int e, int k) {
		if(r<s || e<l)
			return 0;
		else if(s<=l && r<=e)
			return tree[k];
		else {
			int m = (l+r)/2;
			return get(l,m,s,e,2*k)+get(m+1,r,s,e,2*k+1);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n+1];
		depth = new int[n+1];
		start = new int[n+1];
		end = new int[n+1];
		
		int N = (int)Math.pow(2, (int)Math.ceil(Math.log10(n)/Math.log10(2))+1);
		tree = new long[N];
		for(int i = 1;i<=n;i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		int x,y;
		
		for(int i = 1;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			graph[x].add(y);
			graph[y].add(x);
		}
		
		depth[c] = 1;
		dfs(c);
		
		int q = Integer.parseInt(br.readLine());
		int o,a;
		for(int i = 0;i<q;i++) {
			st = new StringTokenizer(br.readLine()," ");
			o = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			
			switch(o) {
			case 1:
				update(0,n-1,start[a],1);
				break;
			case 2:
				sb.append(get(0,n-1,start[a],end[a],1)*depth[a]).append("\n");
			}
		}
		System.out.println(sb.toString());
		
	}
}