import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static long[] tree;
	static long[] group;
	
	static long setTree(int s, int e, int k) {
		if(s==e)
			return tree[k] = group[s];
		else {
			int m = (s+e)/2;
			return tree[k] = setTree(s,m,2*k)+setTree(m+1,e,2*k+1);
		}
	}
	
	static long update(int l, int r, int ind ,long v, int k) {
		if(l<=ind && ind<=r) {		
			if(l==r) {
				group[l]+=v;
				return tree[k]+=v;
				
			}
			else {
				int m = (l+r)/2;
				return tree[k] = update(l,m,ind,v,2*k)+update(m+1,r,ind,v,2*k+1);				
			}
		}
		else {
			return tree[k];
		}
	}
	static int getNum(int l, int r, long n, int k) {
		if(l==r)
			return l+1;
		int m = (l+r)/2;
		if(tree[2*k]>=n) {
			return getNum(l,m,n,2*k);
		}
		else {
			return getNum(m+1,r,n-tree[2*k],2*k+1);
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		group = new long[N];
		tree = new long[4*N];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 0;i<N;i++) {
			group[i] = Integer.parseInt(st.nextToken());
		}
		setTree(0,N-1,1);
		int M = Integer.parseInt(br.readLine());
		int a,b;
		long c;
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			
			switch(a) {
			case 1:
				b = Integer.parseInt(st.nextToken())-1;
				c = Long.parseLong(st.nextToken());
				update(0,N-1,b,c,1);
				break;
			case 2:
				c = Long.parseLong(st.nextToken());
				sb.append(getNum(0,N-1,c,1)).append("\n");
			}
		}
		
		System.out.println(sb.toString());	
	}
}