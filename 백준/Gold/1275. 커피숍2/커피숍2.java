import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int n,q;
	static long[] tree;
	static long[] nums;
	static long makeTree(int s,int e, int k) {
		if(s==e) {
			return tree[k] = nums[s];
		}
		else {
			int m = (s+e)/2;
			return tree[k] = makeTree(s,m,2*k)+makeTree(m+1,e,2*k+1);
		}
	}
	static long getSum(int l, int r, int s, int e, int k) {
		if(r<s || e<l)
			return 0;
		else if(s<=l &&r<=e)
			return tree[k];
		else {
			int m = (l+r)/2;
			return getSum(l,m,s,e,2*k)+getSum(m+1,r,s,e,2*k+1);
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
				tree[k] = tree[2*k]+tree[2*k+1];
			}
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		tree = new long[4*n];
		nums = new long[n];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 0;i<n;i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		makeTree(0,n-1,1);
		int x,y,a;
		long b;
		for(int i = 0;i<q;i++) {
			st = new StringTokenizer(br.readLine()," ");
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			a = Integer.parseInt(st.nextToken())-1;
			b = Long.parseLong(st.nextToken());
			if(x<y)
				sb.append(getSum(0,n-1,x,y,1)).append("\n");
			else
				sb.append(getSum(0,n-1,y,x,1)).append("\n");
			update(0,n-1,a,b,1);
			nums[a] = b;
		}
		System.out.println(sb.toString());
	}
}