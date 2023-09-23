import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[] tree;
	static int[] nums;
	
	static int initTree(int s, int e ,int k) {
		if(s==e) {
			return tree[k] = nums[s];
		}
		else {
			int mid = (s+e)/2;
			return tree[k] = Math.max(initTree(s,mid,2*k), initTree(mid+1,e,2*k+1));
		}
	}
	
	static int getMax(int l, int r ,int s, int e, int k) {
		if(r<s || e<l)
			return 0;
		else if(s<=l && r<=e){
			return tree[k];
		}
		else {
			int mid = (l+r)/2;
			return Math.max(getMax(l,mid,s,e,2*k), getMax(mid+1,r,s,e,2*k+1));
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		nums = new int[n];
		tree = new int[4*n];
		
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0;i<n;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		initTree(0,n-1,1);
		int target = 2*m-2;
		for(int i = 2*m-2;i<n;i++) {
			sb.append(getMax(0,n-1,i-target,i,1)).append(" ");
		}
		System.out.println(sb.toString());
	}
}