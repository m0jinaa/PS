import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int n,m;
	static int[] nodes;
	static long[] tree;
	
	static void update(int l , int r, int ind,int k) {
		if(l<=ind && ind<=r) {
			if(l==r) {
				tree[k]++;
				nodes[ind]++;
			}
			else {
				int mid = (l+r)/2;
				update(l,mid,ind,2*k);
				update(mid+1,r,ind,2*k+1);
				tree[k] = tree[2*k]+tree[2*k+1];
			}
		}
	}
	
	static long get(int l ,int r, int s, int e, int k) {
		if(s>e ||r<s || e<l)
			return 0;
		else if(s<=l && r<=e)
			return tree[k];
		else {
			int mid = (l+r)/2;
			return get(l,mid,s,e,2*k)+get(mid+1,r,s,e,2*k+1);
		}
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		tree = new long[4*n];
		nodes = new int[n];
		
		int[] nums = new int[1000001];
		int a,b;
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0;i<n;i++) {
			a = Integer.parseInt(st.nextToken());
			nums[a] = i;

		}
		
		long answer = 0;
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0;i<n;i++) {
			b = Integer.parseInt(st.nextToken());
			update(0,n-1,nums[b],1);
			answer+=get(0,n-1,nums[b]+1,n-1,1);
		}
		System.out.println(answer);
	}
}