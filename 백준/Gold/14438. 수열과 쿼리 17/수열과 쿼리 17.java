import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int n,m;
	static long[] tree;
	static long[] nums;
	static long INF = Long.MAX_VALUE;
	static long makeTree(int s,int e, int k) {
		if(s==e) {
			return tree[k] = nums[s];
		}
		else {
			int mid = (s+e)/2;
			return tree[k] = Math.min(makeTree(s,mid,2*k),makeTree(mid+1,e,2*k+1));
		}
	}
	static long getMin(int l, int r, int s, int e, int k) {
		if(r<s || e<l)
			return INF;
		else if(s<=l &&r<=e)
			return tree[k];
		else {
			int mid = (l+r)/2;
			return Math.min(getMin(l,mid,s,e,2*k),getMin(mid+1,r,s,e,2*k+1));
		}
	}
	
	static void update(int l, int r, int ind, long v, int k) {
		if(l<=ind && ind<=r) {
			if(l==r) {
				tree[k] = v;
			}
			else {				
				int m = (l+r)/2;
				update(l,m,ind,v,2*k);
				update(m+1,r,ind,v,2*k+1);
				tree[k] = Math.min(tree[2*k],tree[2*k+1]);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		tree = new long[4*n];
		nums = new long[n];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 0;i<n;i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}
		
		m = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		
		makeTree(0,n-1,1);
		
		int a,b,c;
		long cc;
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken())-1;
			if(a==2) {
				c = Integer.parseInt(st.nextToken())-1;
				sb.append(getMin(0,n-1,b,c,1)).append("\n");
			}
			else {
				cc = Long.parseLong(st.nextToken());
				update(0,n-1,b,cc,1);
				nums[a] = b;
			}
		}
		System.out.println(sb.toString());
	}
}