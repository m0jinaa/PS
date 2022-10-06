import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int n,Q;
	static long[] tree;
	static long[] nums;
	static void update(int l, int r, int ind, long v, int k) {
		if(l<=ind && ind<=r) {
			if(l==r) {
				tree[k] +=v;
			}
			else {
				int mid = (l+r)/2;
				update(l,mid,ind,v,2*k);
				update(mid+1,r,ind,v,2*k+1);
				tree[k] = tree[2*k]+tree[2*k+1];
			}
		}
	}
	static long print(int l, int r, int s, int e, int k) {
		if(r<s || e<l)
			return 0;
		else if(s<=l && r<=e)
			return tree[k];
		else {
			int mid = (l+r)/2;
			return print(l,mid,s,e,2*k)+print(mid+1,r,s,e,2*k+1);
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		nums = new long[n];
		tree = new long[4*n];
		
		int o,p,q;
		long x;
		
		for(int i = 0;i<Q;i++) {
			st = new StringTokenizer(br.readLine()," ");
			o = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken())-1;
			
			switch(o) {
			
			case 1:
				x = Long.parseLong(st.nextToken());
				update(0,n-1,p,x,1);
				nums[p]+=x;
				break;
				
			case 2:
				q = Integer.parseInt(st.nextToken())-1;
				sb.append(print(0,n-1,p,q,1)).append("\n");				
			}
		}		
		System.out.println(sb.toString());
	}
}