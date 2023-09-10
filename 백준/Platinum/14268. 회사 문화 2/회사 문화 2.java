import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] start,end;
	static ArrayList<Integer>[] graph;
	static int[] tree;
	static int[] lazy;
	static int t=1;
	static int dfs(int now) {
		start[now] = t++;
		for(int i:graph[now]) {
			dfs(i);
		}
		return end[now] = t-1;
	}
	
	static int update(int l, int r, int s, int e, int v, int k) {
		propagation(l,r,k);
		
		if(r<s || e<l)
			return tree[k];
		else if(s<=l && r<=e) {
			lazy[k]+=v;
			propagation(l,r,k);
			return tree[k];
		}
		else {
			int mid = (l+r)/2;
			return tree[k] = update(l,mid,s,e,v,2*k)+update(mid+1,r,s,e,v,2*k+1);
		}	
	}
	
	static int get(int l, int r, int ind, int k) {
		propagation(l,r,k);
		if(l==r) {
			return tree[k];
		}
		else {
			int mid = (l+r)/2;
			if(ind<=mid)
				return get(l,mid,ind,2*k);
			else
				return get(mid+1,r,ind,2*k+1);
		}
	}
	
	static void propagation(int l, int r, int k) {
		if(lazy[k]!=0) {
			tree[k]+=lazy[k];
			if(l!=r) {
				lazy[2*k]+=lazy[k];
				lazy[2*k+1]+=lazy[k];
			}
			lazy[k] = 0;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		graph = new ArrayList[n+1];
		start = new int[n+1];
		end = new int[n+1];
		int N = 1<<((int)Math.ceil(Math.log10(n)/Math.log10(2))+1);
		tree = new int[N];
		lazy = new int[N];
		for(int i = 1;i<=n;i++) {
			graph[i] = new ArrayList<Integer>();
		}
		int ind;
		for(int i = 1;i<=n;i++) {
			ind = Integer.parseInt(st.nextToken());
			if(ind!=-1)
				graph[ind].add(i);
		}
		
		dfs(1);
		int o,a,b;
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			o = Integer.parseInt(st.nextToken());
			switch(o) {
			case 1:
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				update(1,n,start[a],end[a],b,1);
				break;
			case 2:
				a = Integer.parseInt(st.nextToken());
				sb.append(get(1,n,start[a],1)).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());	
	}
}
