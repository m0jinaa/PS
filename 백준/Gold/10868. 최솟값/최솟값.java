import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int n,m;
	static int[] tree;
	static int[] nums;
	static int INF = Integer.MAX_VALUE;
	static int makeTree(int s, int e, int k) {
		if(s==e) {
			return tree[k] = nums[s];
		}
		else {
			int mid = (s+e)/2;
			return tree[k] = Math.min(makeTree(s,mid,2*k),makeTree(mid+1,e,2*k+1));
		}
	}
	static int getMin(int l,int r,int s,int e,int k) {
		if(r<s || e<l) {
			return INF;
		}
		else if(s<=l && r<=e)
			return tree[k];
		else {
			int mid = (l+r)/2;
			return Math.min(getMin(l,mid,s,e,2*k), getMin(mid+1,r,s,e,2*k+1));
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		tree = new int[4*n];
		nums = new int[n];
		for(int i = 0;i<n;i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		makeTree(0,n-1,1);
		StringBuilder sb = new StringBuilder();
		
		int a,b;
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken())-1;
			b = Integer.parseInt(st.nextToken())-1;
			sb.append(getMin(0,n-1,a,b,1)).append("\n");
		}
		System.out.println(sb.toString());
	}
}