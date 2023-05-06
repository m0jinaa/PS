import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int n,m;
	static int[] tree;
	static int[] lazy;
	
	static int get(int l, int r, int s, int e, int k) {
		propagation(l,r,k);
		if(r<s || e<l)
			return 0;
		else if(s<=l && r<=e) {
			return tree[k];
		}
		else {
			int mid = (l+r)/2;
			return get(l,mid,s,e,2*k)+get(mid+1,r,s,e,2*k+1);
		}
	}
	
	static int update(int l, int r ,int s, int e, int k) {
		propagation(l,r,k);
		
		if(r<s || e<l)
			return tree[k];
		else if(s<=l && r<=e) {
			if(l!=r) {
				lazy[2*k] = 1-lazy[2*k];
				lazy[2*k+1] = 1-lazy[2*k+1];	
			}
			return tree[k] = r-l+1-tree[k];
		}
		else {
			int mid = (l+r)/2;
			
			return tree[k] = update(l,mid,s,e,2*k)+update(mid+1,r,s,e,2*k+1);
		}
	}
	
	static void propagation(int l, int r, int k) {
		if(lazy[k]!=0) {
			tree[k] = r-l+1-tree[k];
			if(l!=r) {
				lazy[2*k] = 1-lazy[2*k];
				lazy[2*k+1] = 1-lazy[2*k+1];
			}
			lazy[k] = 0;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		tree = new int[4*n];
		lazy = new int[4*n];
		
		int o,s,t;
		
		for(int i = 0; i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			o = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken())-1;
			t = Integer.parseInt(st.nextToken())-1;
			
			switch(o) {
			case 0:
				update(0,n-1,s,t,1);
				break;
			case 1:
				sb.append(get(0,n-1,s,t,1)).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());	
	}
}