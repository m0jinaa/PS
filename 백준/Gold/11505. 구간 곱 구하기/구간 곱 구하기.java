import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static long[] tree;
	static long[] nums;
	static int DIV = 1_000_000_007;
	static long makeTree(int s, int e, int k) {
		if(s==e) {
			return tree[k] = nums[s];
		}
		else {
			int mid = (s+e)/2;
			return tree[k] = makeTree(s,mid,2*k)*makeTree(mid+1,e,2*k+1)%DIV;
		}
	}
	static long getMul(int l,int r,int s,int e,int k) {
		if(r<s || e<l) {
			return 1;
		}
		else if(s<=l && r<=e)
			return tree[k];
		else {
			int mid = (l+r)/2;
			return getMul(l,mid,s,e,2*k)*getMul(mid+1,r,s,e,2*k+1)%DIV;
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
				tree[k] = (tree[2*k]*tree[2*k+1])%DIV;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		tree = new long[4*n];
		nums = new long[n];
		for(int i = 0;i<n;i++) {
			nums[i] = Long.parseLong(br.readLine());
		}
		
		makeTree(0,n-1,1);
		StringBuilder sb = new StringBuilder();
		int a,b,c;
		long cc;
		for(int i = 0;i<M+K;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken())-1;
			switch(a) {
			case 1:
				cc = Long.parseLong(st.nextToken());
				update(0,n-1,b,cc,1);
				nums[b]=cc;
				break;
			case 2:
				c = Integer.parseInt(st.nextToken())-1;
				sb.append(getMul(0,n-1,b,c,1)).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());
	}
}