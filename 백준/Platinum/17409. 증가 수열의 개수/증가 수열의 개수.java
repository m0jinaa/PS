import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static long[][] tree;
	static long[][] dp;
	static final int MOD = 1_000_000_007;
	static void update(int x,int l, int r, int ind,long v, int k) {
		tree[x][k]= (tree[x][k]+v)%MOD;
		if(l==r)
			return;
		int m = (l+r)/2;
		if(ind<=m)
			update(x,l,m,ind,v,2*k);
		else
			update(x,m+1,r,ind,v,2*k+1);
	}
	
	static long get(int x,int l, int r, int s, int e ,int k) {
		if(r<s || e<l)
			return 0;
		else if(s<=l && r<=e)
			return tree[x][k];
		else {
			int m = (l+r)/2;
			return (get(x,l,m,s,e,2*k)+get(x,m+1,r,s,e,2*k+1))%MOD;
		}
	}
	static class Num implements Comparable<Num>{
		int x,ind;

		public Num(int x, int ind) {
			super();
			this.x = x;
			this.ind = ind;
		}

		@Override
		public int compareTo(Num o) {
			return this.x-o.x;
		}	
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Num[] nums = new Num[n];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0;i<n;i++) {
			nums[i] = new Num(Integer.parseInt(st.nextToken()),i+1);
		}
		
		Arrays.sort(nums);
		
		int N = (int)Math.pow(2, (int)Math.ceil(Math.log10(n+1)/Math.log10(2))+1);
		
		tree = new long[k+1][N];
		dp = new long[k+1][n+1];
		
		
		update(0,0,n,0,1,1);
		for(Num num:nums) {
			for(int i = 1;i<=k;i++) {
				if(num.ind+1<i)
					break;
				dp[i][num.ind] = get(i-1,0,n,0,num.ind-1,1);
				update(i,0,n,num.ind,dp[i][num.ind],1);
			}
		}
		
		long cnt = 0;
		for(int i = 1;i<=n;i++) {
			cnt = (cnt+dp[k][i])%MOD;
		}
		
		System.out.println(cnt);		
	}
}