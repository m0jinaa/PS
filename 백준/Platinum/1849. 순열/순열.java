import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	static int n;
	static int[] tree;
	static int[] nums;
	
	static int initTree(int s, int e , int k) {
		if(s==e) {
			return tree[k] = 1;
		}
		else {
			int m = (s+e)/2;
			return tree[k] = initTree(s,m,2*k)+initTree(m+1,e,2*k+1);
		}
	}
	
	static int get(int l, int r , int c, int k) {
		if(l==r) {
			tree[k] = 0;
			return l;
		}
		else {
			tree[k]-=1;
			int m = (l+r)/2;
			if(tree[2*k]<c) {
				return get(m+1,r,c-tree[2*k],2*k+1);
			}
			else {
				return get(l,m,c,2*k);
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		tree = new int[4*n];
		nums = new int[n];
		int a,ind;
		initTree(0,n-1,1);
		for(int i = 1;i<=n;i++) {
			a = Integer.parseInt(br.readLine());
			
			ind = get(0,n-1,a+1,1);
			nums[ind] = i;
			
		}	
		StringBuilder sb = new StringBuilder();
		for(int i:nums) {
			sb.append(i).append("\n");
		}		
		System.out.println(sb.toString());		
	}
}