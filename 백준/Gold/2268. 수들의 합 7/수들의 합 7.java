import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int n,m;
	static long[] tree;
	static long[] nums;

	static long getSum(int l, int r, int s, int e, int k) {
		if(r<s || e<l)
			return 0;
		else if(s<=l &&r<=e)
			return tree[k];
		else {
			int mid = (l+r)/2;
			return getSum(l,mid,s,e,2*k)+getSum(mid+1,r,s,e,2*k+1);
		}
	}
	
	static void update(int l, int r, int ind, long v, int k) {
		if(l<=ind && ind<=r) {
			if(l==r) {
				tree[k] = v;
			}
			else {				
				int mid = (l+r)/2;
				update(l,mid,ind,v,2*k);
				update(mid+1,r,ind,v,2*k+1);
				tree[k] = tree[2*k]+tree[2*k+1];
			}
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		tree = new long[4*n];
		nums = new long[n];
		
		StringBuilder sb = new StringBuilder();
		
		int a,b,c;
		long cc;
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken())-1;
			if(a==0) {
				c = Integer.parseInt(st.nextToken())-1;
				if(b<c)
					sb.append(getSum(0,n-1,b,c,1)).append("\n");
				else
					sb.append(getSum(0,n-1,c,b,1)).append("\n");			
			}
			else {
				cc = Long.parseLong(st.nextToken());
				update(0,n-1,b,cc,1);
				nums[b] = cc;
			}
		}
		System.out.println(sb.toString());
	}
}