import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int n,m;
	static int[][] tree;
	static int[] nums;
	static int INF = Integer.MAX_VALUE;
	static int[] makeTree(int s, int e, int k) {
		if(s==e) {
			return tree[k] = new int[] {nums[s],nums[s]};
		}
		else {
			int mid = (s+e)/2;
			int[] left = makeTree(s,mid,2*k);
			int[] right = makeTree(mid+1,e,2*k+1);
			return tree[k] = new int[] {Math.min(left[0], right[0]),Math.max(left[1], right[1])};
		}
	}
	static int[] getMinMax(int l,int r,int s,int e,int k) {
		if(r<s || e<l) {
			return new int[] {INF,0};
		}
		else if(s<=l && r<=e)
			return tree[k];
		else {
			int mid = (l+r)/2;
			int[] left = getMinMax(l,mid,s,e,2*k);
			int[] right = getMinMax(mid+1,r,s,e,2*k+1);
			return new int[] {Math.min(left[0], right[0]),Math.max(left[1], right[1])};
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		tree = new int[4*n][2];
		nums = new int[n];
		for(int i = 0;i<n;i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		makeTree(0,n-1,1);
		StringBuilder sb = new StringBuilder();
		
		int a,b;
		int[] ans;
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken())-1;
			b = Integer.parseInt(st.nextToken())-1;
			ans = getMinMax(0,n-1,a,b,1);
			sb.append(ans[0]).append(" ").append(ans[1]).append("\n");
		}
		System.out.println(sb.toString());
	}
}